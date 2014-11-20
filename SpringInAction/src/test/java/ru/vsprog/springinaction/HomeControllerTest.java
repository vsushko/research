package ru.vsprog.springinaction;

import org.junit.Test;
import ru.vsprog.springinaction.chapter7.Spittle;
import ru.vsprog.springinaction.chapter8.HomeController;
import ru.vsprog.springinaction.chapter8.SpitterService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

/**
 * Created by vsa
 * Date: 20.11.14.
 */
public class HomeControllerTest {
    private static final int DEFAULT_SPITTLES_PER_PAGE = 25;

    @Test
    public void shouldDisplayRecentSpittles() {
        List<Spittle> expectedSpittles = Arrays.asList(new Spittle(), new Spittle(), new Spittle());

        // Фиктивный объект SpitterService
        SpitterService spitterService = mock(SpitterService.class);

        when(spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE)).thenReturn(expectedSpittles);

        // Создать контроллер
        HomeController controller = new HomeController(spitterService);

        HashMap<String, Object> model = new HashMap<String, Object>();

        // вызвать обработчик
        String viewName = controller.showHomePage(model);

        assertEquals("home", viewName);

        // Проверить результаты
        assertSame(expectedSpittles, model.get("spittles"));
        verify(spitterService).getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
    }


}
