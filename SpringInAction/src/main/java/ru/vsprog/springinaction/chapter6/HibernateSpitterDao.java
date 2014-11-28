package ru.vsprog.springinaction.chapter6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import ru.vsprog.springinaction.chapter7.Spittle;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vsa
 * Date: 14.11.14.
 */
@Repository
public class HibernateSpitterDao implements SpitterDAO {
    private SessionFactory sessionFactory;

    // Конструирует DAO
    @Autowired
    public HibernateSpitterDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Извлекает текущий сеанс из фабрики SessionFactory
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    // Использует текущий сеанс
    // Метод не будет вызван, если пользователь не обладает привелегией ROLE_SPITTER
    @Secured("ROLE_SPITTER")
    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);
    }

    // несколько привелегий ROLE_SPITTER и ROLE_ADMIN
    @RolesAllowed({"ROLE_SPITTER", "ROLE_ADMIN"})
    public void addSpittle(Spitter spitter) {
        currentSession().save(spitter);
    }

    // Использует текущий сеанс
    // проверка условия перед вызовом метода
    @PreAuthorize("hasRole('ROLE_SPITTER' and #spittle.text.length() <= 140 or hasRole('ROLE_PREMIUM'")
    public Spitter getSpitterById(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    // Использует текущий сеанс
    public void saveSpitter(Spitter spitter) {
        currentSession().update(spitter);
    }

    @Override
    public void saveSpittle(Spittle spittle) {

    }

    // Возвращает объект, если он принадлежит авторизованному пользователю
    @PostAuthorize("returnObject.spitter.username == pincipal.username")
    public Spittle getSpittleById(long id) {
        return null;
    }

    // фильтрация после вызова метода
    @PreAuthorize("hasRole('ROLE_SPITTER')")
    @PostFilter("filterObject.spitter.username == principal.name")
    public List<Spittle> getABunchOfSpittles() {
        return new ArrayList<Spittle>();
    }

    // возможность удалять сообщения
    @PreAuthorize("hasRole('ROLE_SPITTER')")
    @PostFilter("hasPermission(filterObject, 'delete'")
    public List<Spittle> getSpittlesToDelet() {
        return new ArrayList<Spittle>();
    }
}
