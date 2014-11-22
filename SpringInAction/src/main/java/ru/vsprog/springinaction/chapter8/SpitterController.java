package ru.vsprog.springinaction.chapter8;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vsprog.springinaction.chapter6.Spitter;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by vsa
 * Date: 21.11.14.
 */
@Controller
// Корневой путь URL
@RequestMapping("/spitter")
public class SpitterController {
    private final SpitterService spitterService;

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
    @RequestMapping(method = RequestMethod.POST)
    public String addSpitterFromForm(@Valid Spitter spitter, BindingResult bindingResult) {
        // проверка ошибок
        if (bindingResult.hasErrors()) {
            return "spitters/eidt";
        }
        // сохранить объект Spitter
        spitterService.saveSpitter(spitter);

        // переадресовать после запроса POST
        return "redirect:/spitters/" + spitter.getUserName();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        model.addAttribute(spitterService.getSpitter(username));
        return "spitters/view";
    }
}
