package chapter03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class MainTest {
    /**
     * Method under test: {@link Main#getDayAfterDays(LocalDate, int)}
     */
    @Test
    void testGetDayAfterDays() {
        assertEquals("1970-01-03", Main.getDayAfterDays(LocalDate.ofEpochDay(1L), 1).toString());
    }

    /**
     * Method under test: {@link Main#getDayAfterDays(LocalDate, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetDayAfterDays2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at chapter03.Main.getDayAfterDays(Main.java:179)
        //   See https://diff.blue/R013 to resolve this issue.

        Main.getDayAfterDays(null, 1);
    }

    /**
     * Method under test: {@link Main#localTimeToAllTimezones()}
     */
    @Test
    void testLocalTimeToAllTimezones() {
        assertEquals(601, Main.localTimeToAllTimezones().size());
    }
}

