package ru.vsprog.springinaction.chapter8;

import org.apache.commons.io.FileUtils;
import org.jets3t.service.S3Service;
import org.jets3t.service.acl.AccessControlList;
import org.jets3t.service.acl.GroupGrantee;
import org.jets3t.service.acl.Permission;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.vsprog.springinaction.chapter6.Spitter;
import ru.vsprog.springinaction.chapter7.Spittle;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by vsa
 * Date: 21.11.14.
 */
@Controller
// Корневой путь URL, обрабатывает запросы к URL /spittles
@RequestMapping("/spitter")
public class SpitterController {
    private final SpitterService spitterService;
    private String webRootPath;
    private String s3SecretKey;
    private String s3AccessKey;

    @Inject
    public SpitterController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    // обрабатывает GET-запросы к URL /spitter/spittles
    @RequestMapping(value = "/spittles", method = RequestMethod.GET)
    public String listSpittlesForSpitter(
            @RequestParam("spitter") String username, Model model) {
        Spitter spitter = spitterService.getSpitter(username);
        model.addAttribute(spitter);
        model.addAttribute(spitterService.getSpittlesForSpitter(username));
        return "spittles/list";
    }

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createSpitterProfile(Model model) {
        model.addAttribute(new Spitter());
        return "spitters/edit";
    }

    // аннотация @Valid означает, что объект Spitter
    // должен подвергаться проверке перед передачей методу
    // RequestParam required = false означает, что параметр не обязательный
    @RequestMapping(method = RequestMethod.POST)
    public String addSpitterFromForm(@Valid Spitter spitter, BindingResult bindingResult,
                                     @RequestParam(value = "image", required = false) MultipartFile image) {
        // проверка ошибок
        if (bindingResult.hasErrors()) {
            return "spitters/eidt";
        }
        // сохранить объект Spitter
        spitterService.saveSpitter(spitter);

        try {
            if (!image.isEmpty()) {
                // Проверить изображение
                validateImage(image);
                // сохранить файл
                saveImage(spitter.getId() + ".jpg", image);
            }
        } catch (ImageUploadException e) {
            bindingResult.reject(e.getMessage());
        }


        // переадресовать после запроса POST
        return "redirect:/spitters/" + spitter.getUserName();

    }

    private void validateImage(MultipartFile image) throws ImageUploadException {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new ImageUploadException("Only JPG images accepted");
        }
    }

    public void saveImage(String filename, MultipartFile image) throws ImageUploadException {
        try {
            File file = new File(webRootPath + "/resources/" + filename);
            FileUtils.writeByteArrayToFile(file, image.getBytes());

        } catch (IOException e) {
            throw new ImageUploadException("Unagle to save image");
        }
    }

    private void saveImage(String filename, MultipartFile image, int param) throws ImageUploadException {
        try {
            AWSCredentials awsCredentials = new AWSCredentials(s3AccessKey, s3SecretKey);
            // настройка S3
            S3Service s3Service = new RestS3Service(awsCredentials);

            // Создать объекты, представляющие хранилище и изображение
            S3Bucket imageBucket = s3Service.getBucket("spitterImages");
            S3Object imageObject = new S3Object(filename);

            // Скопировать данные изображеняи в объект
            imageObject.setDataInputStream(new ByteArrayInputStream(image.getBytes()));
            imageObject.setContentLength(image.getBytes().length);
            imageObject.setContentType("image/jpeg");

            // Определить разрешения
            AccessControlList accessControlList = new AccessControlList();
            accessControlList.setOwner(imageBucket.getOwner());
            accessControlList.grantPermission(GroupGrantee.ALL_USERS, Permission.PERMISSION_READ);
            imageObject.setAcl(accessControlList);

            // Сохранить изображение
            s3Service.putObject(imageBucket, imageObject);

        } catch (Exception e) {
            throw new ImageUploadException("Unable to save image");
        }
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        model.addAttribute(spitterService.getSpitter(username));
        return "spitters/view";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getSpittle(@PathVariable("id") long id, Model model) {
        model.addAttribute(spitterService.getSpittleById(id));
        return "spittles/view";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putSpittle(@PathVariable("id") long id, @Valid Spittle spittle) {
        spitterService.saveSpittle(spittle);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSpittle(@PathVariable("id") long id) {
        spitterService.deleteSpittle(id);
    }

    // обрабатывает POST запросы
    @RequestMapping(method = RequestMethod.POST)
    // возвращает ответ HTTP 201
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Spittle createSpittle(@Valid Spittle spittle,
                                               BindingResult result,
                                               HttpServletResponse response) throws Exception {
        if (result.hasErrors()) {
            throw new Exception();
        }

        spitterService.saveSpittle(spittle);

        // Указать местоположение ресурса
        response.setHeader("Location", "spittles/" + spittle.getId());
        return spittle;
    }

}
