package ru.vsprog.springinaction;

import org.apache.commons.lang.time.FastDateFormat;
import org.junit.Test;
import ru.vsprog.springinaction.chapter5.Magician;
import ru.vsprog.springinaction.chapter5.Volunteer;

import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

/**
 * Created by vsa
 * Date: 06.11.14.
 */
public class ProjectTest {
    @Test
    public void testRuWinterTransition2014() throws Exception {
        FastDateFormat format = FastDateFormat.getInstance("dd-MM-yyyy HH:mm:ss");

        TimeZone tzBackup = TimeZone.getDefault();

        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Yekaterinburg"));

        try {
            Calendar cal = Calendar.getInstance();

            cal.set(2014, 9, 25, 14, 0, 0);
            assertEquals(format.format(cal), "25-10-2014 14:00:00");
            cal.add(Calendar.HOUR_OF_DAY, 24);
            assertEquals(format.format(cal), "26-10-2014 13:00:00");
        } finally {
            TimeZone.setDefault(tzBackup);
        }
    }

    @Test
    public void magicianShouldReadVolunteersMind() {
        Volunteer volunteer = new Volunteer();
        volunteer.thinkOfSomething("Queen of Hearts");

        Magician magician = new Magician();
        magician.interceptThoughts("Queen of Hearts");

        assertEquals("Queen of Hearts", magician.getThoughts());
    }
}
