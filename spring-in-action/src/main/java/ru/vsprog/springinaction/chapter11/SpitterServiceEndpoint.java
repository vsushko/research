package ru.vsprog.springinaction.chapter11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vsprog.springinaction.chapter6.Spitter;
import ru.vsprog.springinaction.chapter7.Spittle;
import ru.vsprog.springinaction.chapter8.SpitterService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * SpringBeanAutowiringSupport включает поддержку автоматического связывания.
 *
 * Created by vsa
 * Date: 30.11.14.
 */
@Component // +
@WebService(serviceName = "SpitterService")
public class SpitterServiceEndpoint { // extends SpringBeanAutowiringSupport

    @Autowired
    SpitterService spitterService;

    @WebMethod
    public void addSpittle(Spittle spittle) {
        spitterService.saveSpittle(spittle);
    }

    @WebMethod
    public void deleteSpittle(long spittleId) {
        // выполнение делегируется слежбе SpitterService
        spitterService.deleteSpittle(spittleId);
    }

    @WebMethod
    public List<Spittle> getRecentSpittles(int spittleCount) {
        // Выполнение делегируется службе SpitterService
        return spitterService.getRecentSpittles(spittleCount);
    }

    @WebMethod
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        // Выполнение делегируется службе SpitterService
        return spitterService.getSpittlesForSpitter(spitter);
    }

}
