package ru.vsprog.springinaction.chapter8;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.BindException;

/**
 * Created by vsa
 * Date: 25.11.2014.
 */
public class RantsForVehicleController {

    private final String BASE_VIEW_NAME = "vehicleRants";

    private String getViewName(HttpServletRequest request) {
        String requesUri = request.getRequestURI();
        String extension = "." + requesUri.substring(requesUri.lastIndexOf("."));

        if ("htm".equals(extension)) {
            extension = "";
        }

        return BASE_VIEW_NAME + extension;
    }

    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response,
                                  Object command, BindException errors) throws Exception {
        // code...

        return new ModelAndView(getViewName(request), null);
    }
}
