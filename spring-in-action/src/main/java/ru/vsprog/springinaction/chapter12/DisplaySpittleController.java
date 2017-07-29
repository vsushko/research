package ru.vsprog.springinaction.chapter12;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vsprog.springinaction.chapter8.SpitterService;

import javax.inject.Inject;

/**
 * Контроллер противоречащий архитектуре REST.
 *
 * Created by vsa
 * Date: 30.11.14.
 */
@Controller
// отображение URL, противоречащее REST
@RequestMapping("/displaySpittle.html")
public class DisplaySpittleController {
    private final SpitterService spitterService;

    @Inject
    public DisplaySpittleController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showSpittle(@RequestParam("id") long id, Model model) {
        model.addAttribute(spitterService.getSpittleById(id));
        return "spittles/view";
    }
}
