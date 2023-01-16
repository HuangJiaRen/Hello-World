package com.xdf.huangli.test;

import com.xdf.huangli.util.CompareUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-11-04 13:20
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate startDate = LocalDate.of(2021, 1, 1);
        System.out.println(CompareUtil.lessOrEqual(startDate, now));
        startDate = startDate.plusMonths(1);
        System.out.println(startDate);

        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime startTime = nowTime.with(LocalTime.MIN).withDayOfMonth(1);
        LocalDateTime endTime = nowTime.with(LocalTime.MAX).withDayOfMonth(nowTime.getMonth().minLength());
        System.out.println(startTime);
        System.out.println(endTime);

        now.withYear(2021);
        for (int i = 1; i <= 12; i++) {
            LocalDate withMonth = now.withMonth(i);
            System.out.println("m-->" + withMonth.getMonthValue());
            System.out.println(StringUtils.addZero(withMonth));
        }
    }
}
