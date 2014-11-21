package ru.vsprog.springinaction.chapter8;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vsprog.springinaction.chapter6.Spitter;

import javax.inject.Inject;

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
    @RequestMapping(value = "/spittles", method= RequestMethod.GET)
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

}
