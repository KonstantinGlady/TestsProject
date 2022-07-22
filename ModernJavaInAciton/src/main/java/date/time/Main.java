package date.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2014, 7, 22);
        int year = date.getYear();
        System.out.println(year);

        LocalTime time = LocalTime.of(12,34);
        System.out.println(time.getHour());

        System.out.println(LocalTime.now());

        LocalDateTime localDateTime = LocalDateTime.of(2012,11,23,12,03);
        System.out.println(localDateTime);

        LocalDate date2 = localDateTime.toLocalDate();
        System.out.println(date2);
        LocalTime time2 = localDateTime.toLocalTime();
        System.out.println(time2);

        Duration duration = Duration.between(LocalTime.of(23,12), time);
        System.out.println(duration);
    }
}
