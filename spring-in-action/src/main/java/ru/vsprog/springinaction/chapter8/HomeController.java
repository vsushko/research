package ru.vsprog.springinaction.chapter8;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
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
// Экспортирует HomeController как MBean
@ManagedResource(objectName = "spitter:name=HomeController")
public class HomeController {
    private static final int DEFAULT_SPITTLES_PER_PAGE = 25;
    private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;
    private SpitterService spitterService;

    // внедрим SpitterService
    @Inject
    public HomeController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    // Экспортирует spittlesPerPage как управляемый атрибут
    @ManagedAttribute
    public int getSpittlesPerPage() {
        return spittlesPerPage;
    }

    // Экспортирует spittlesPerPage как управляемый атрибут
    @ManagedAttribute
    public void setSpittlesPerPage(int spittlesPerPage) {
        this.spittlesPerPage = spittlesPerPage;
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
