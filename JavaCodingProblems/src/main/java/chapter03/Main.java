package chapter03;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.parse("2007-12-22");
        System.out.println(localDate);

        LocalTime localTime = LocalTime.parse("10:22:33");
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.parse("2017-11-23T10:55:22");
        System.out.println(localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2011-11-12T11:22:00+03:00[Asia/Tokyo]");
        System.out.println(zonedDateTime);

        OffsetTime offsetTime = OffsetTime.parse("11:33:22+01:00");
        System.out.println(offsetTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.parse("2011-11-12T21:23:00+02:00");
        System.out.println(offsetDateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDateFormatted = LocalDate.parse("22.11.2011", dateTimeFormatter);
        System.out.println(localDateFormatted);

        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("HH|mm|ss");
        LocalTime localTime2 = LocalTime.parse("22|11|00", dateTimeFormatter2);
        System.out.println(localTime2);

        LocalDateTime localDateTimeNow = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter3.format(localDateTimeNow));

        LocalDate localDate1 = LocalDate.now();
        LocalTime localTime1 = LocalTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate1, localTime1);
        System.out.println(localDateTime1);

        //alternative timestamp of machine time
        Instant timeStamp = Instant.now();
        System.out.println(timeStamp);

        //same as before
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());

        Instant instant = Instant.parse("2022-10-10T10:40:24.681190300Z");
        System.out.println(instant);

        Instant twoHoursLater = Instant.now().plus(2, ChronoUnit.HOURS);
        System.out.println(twoHoursLater);

        Instant tenMinutesEarlier = Instant.now().minus(10, ChronoUnit.MINUTES);
        System.out.println(tenMinutesEarlier);

        Instant timeStamp1 = Instant.now();
        Instant timeStamp2 = timeStamp1.plusSeconds(10);
        System.out.println(timeStamp1.isBefore(timeStamp2));
        System.out.println(timeStamp1.isAfter(timeStamp2));
        System.out.println(timeStamp1.until(timeStamp2, ChronoUnit.SECONDS));

        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
        System.out.println(localDateTime2);
        Instant localDateTime3 = LocalDateTime.now().toInstant(ZoneOffset.UTC);
        System.out.println(localDateTime3);

        Period period = Period.ofDays(120);
        System.out.println(period);

        Period period1 = Period.of(2200, 12, 11);
        System.out.println(period1);

        LocalDateTime localDateTime4 = LocalDateTime.now();
        Period period2 = Period.of(localDateTime4.getYear(), localDateTime4.getMonthValue(), localDateTime4.getDayOfMonth());
        System.out.println(period2);

        Period period3 = Period.parse("P2000Y11M22D");
        System.out.println(period3);

        LocalDate localDateStart = LocalDate.parse("2000-11-11");
        LocalDate localDateEnd = LocalDate.parse("2001-11-22");
        Period period4 = Period.between(localDateStart, localDateEnd);
        System.out.println(period4);

        System.out.println(period4.isNegative());
        System.out.println(period4.plusDays(10));

        LocalDateTime localDateTime5 = LocalDateTime.of(2001, 8, 23, 11, 22);
        LocalDateTime localDateTime6 = LocalDateTime.of(2004, 11, 21, 1, 21);

        Duration duration = Duration.between(localDateTime5, localDateTime6);
        System.out.println(duration.isNegative());

        StringBuilder sb = new StringBuilder();
        sb.append(duration.toDays())
                .append("d:")
                .append(duration.toHoursPart())
                .append("h:");
        System.out.println(sb.toString());

        List<String> localTimeZones = localTimeToAllTimezones();
        Collections.sort(localTimeZones);
        localTimeZones.forEach(System.out::println);

        ////////////
        LocalDateTime ldt = LocalDateTime.of(2019, Month.FEBRUARY, 26, 16, 0);
        System.out.println(ldt);
        ZonedDateTime auPerthDepart = ldt.atZone(ZoneId.of("Australia/Perth"));
        System.out.println(auPerthDepart);
        ZonedDateTime auBucharestArrive = auPerthDepart.plusHours(15).plusMinutes(30);
        System.out.println(auBucharestArrive);
        ZonedDateTime euBucharestDepart = auPerthDepart.withZoneSameInstant(ZoneId.of("Europe/Bucharest"));
        System.out.println(euBucharestDepart);
        ZonedDateTime euBucharestArrive = auBucharestArrive.withZoneSameInstant(ZoneId.of("Europe/Bucharest"));
        System.out.println(euBucharestArrive);
        OffsetDateTime offsetDepart = auPerthDepart.withZoneSameInstant(ZoneId.of("UTC")).toOffsetDateTime();
        System.out.println(offsetDepart);
        OffsetDateTime offsetArrive = auBucharestArrive.withZoneSameInstant(ZoneId.of("UTC")).toOffsetDateTime();
        System.out.println(offsetArrive);

        long unixTimestamp = 3761758800L;
        Instant instant1 = Instant.ofEpochSecond(unixTimestamp);
        Date date = Date.from(instant1);
        System.out.println(date);
        LocalDateTime localDateTime7 = LocalDateTime.ofInstant(instant1, ZoneId.of("Australia/Perth"));
        System.out.println(localDateTime7);

        System.out.println(getDayAfterDays(LocalDate.of(2012, 11, 11), 21));

        LocalDate nextSaturday = LocalDate.now().with(NEXT_SATURDAY);
        System.out.println("next saturday: " + nextSaturday);

        LocalDate startLocalDate = LocalDate.of(2011, 11, 12);
        LocalDate endLocalDate = LocalDate.of(2011, 11, 16);

        for (LocalDate date1 = startLocalDate; date1.isBefore(endLocalDate); date1 = date1.plusDays(1)) {
            System.out.println(date1);
        }

        startLocalDate.datesUntil(endLocalDate).forEach(System.out::println);
        startLocalDate.datesUntil(endLocalDate, Period.ofWeeks(1)).forEach(System.out::println);

        LocalDate startLocalDate1 = LocalDate.of(2000, 1, 1);
        LocalDate endLocalDate1 = LocalDate.of(2011, 11, 11);
        long years = ChronoUnit.YEARS.between(startLocalDate1, endLocalDate1);
        System.out.println(years);

        Period period5 = Period.between(startLocalDate1, endLocalDate1);
        System.out.println(period5.getYears() + " " + period5.getDays());

        long n = ChronoUnit.DAYS.between(startLocalDate1, endLocalDate1);
        System.out.println(n);

        Clock fixedClock = Clock.fixed(Instant.now(), ZoneOffset.UTC);
        System.out.println(fixedClock);

        Clock tickClock = Clock.tickSeconds(ZoneId.of("Europe/Bucharest"));
        System.out.println(tickClock.instant());
    }

    static TemporalAdjuster NEXT_SATURDAY = TemporalAdjusters.ofDateAdjuster(today -> {
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.SATURDAY) {
            return today;
        }

        if (dayOfWeek == DayOfWeek.SUNDAY) {
            return today.plusDays(6);
        }

        return today.plusDays(6 - dayOfWeek.getValue());
    });

    public static LocalDate getDayAfterDays(LocalDate startDate, int days) {

        Period period = Period.ofDays(days);
        TemporalAdjuster ta = p -> p.plus(period);
        LocalDate endDate = startDate.with(ta);
        return endDate;
    }

    public static List<String> localTimeToAllTimezones() {
        List<String> result = new ArrayList<>();
        Set<String> zonedIds = ZoneId.getAvailableZoneIds();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd 'T' HH:mm:ss a Z");
        ZonedDateTime zld = ZonedDateTime.now();

        zonedIds.forEach((zonedId) -> {
            result.add(zld.format(formatter) + " in " + zonedId + "is" +
                    zld.withZoneSameInstant(ZoneId.of(zonedId)).format(formatter));
        });
        return result;
    }
}
