package ru.vsprog.springinaction.chapter8;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by vsa
 * Date: 20.11.14.
 */
// Объявить как контроллер
@SuppressWarnings("ALL")
@Controller
public class HomeController {
    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;

    private SpitterService spitterService;

    // внедрим SpitterService
    @Inject
    public HomeController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    // Обрабатывать запросы на получение главной страницы
    @RequestMapping({"/", "/home"})
    public String showHomePage(Map<String, Object> model) {
        // добавить сообщения модель
        model.put("spittles", spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE));
        // вернуть имя представления
        return "home";
    }

}
