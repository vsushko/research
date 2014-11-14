package ru.vsprog.springinaction.chapter6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);
    }

    // Использует текущий сеанс
    public Spitter getSpitterById(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    // Использует текущий сеанс
    public void saveSpitter(Spitter spitter) {
        currentSession().update(spitter);
    }
}
