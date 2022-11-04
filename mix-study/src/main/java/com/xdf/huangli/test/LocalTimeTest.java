package com.xdf.huangli.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-11-03 13:00
 */
public class LocalTimeTest {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2021, 1, 1);
        LocalDateTime startTime = startDate.atStartOfDay().with(LocalTime.MIN).withDayOfMonth(1);
        System.out.println(startTime.toString());
        LocalDateTime endTime = startDate.atStartOfDay().with(LocalTime.MAX).withDayOfMonth(startDate.getMonth().minLength());
        System.out.println(endTime.toString());
    }
}
