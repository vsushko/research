package ru.vsprog.javanext;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.*;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by: vsa
 * Date: 24.07.14
 */
public class TicketHibernateDaoTest {
    private static SessionFactory factory;
    private static TicketHibernateDao ticketDao;
    private static Ticket ticket;
    private static Ticket ticket2;

    @BeforeClass
    public static void baseSetUp() {
        factory = new Configuration().buildSessionFactory();
        ticketDao = new TicketHibernateDao(factory);
    }

    @Before
    public void setUpTest() {
        ticket = new Ticket(1);
        ticketDao.save(ticket);
        ticket2 = new Ticket(2);
        ticketDao.save(ticket2);
    }

    @Test
    public void findTicketByIdHappyPath() throws Exception {
        Ticket ticket = ticketDao.findTicketById(1);
        assertEquals(new BigDecimal("30.0"), ticket.getDiscountPrice());
    }

    @After
    public void tearDown() {
        ticketDao.delete(ticket);
        ticketDao.delete(ticket2);
    }

    @AfterClass
    public static void baseTearDown() {
        factory.close();
    }

}
