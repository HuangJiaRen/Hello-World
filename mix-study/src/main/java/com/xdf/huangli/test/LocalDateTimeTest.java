package com.xdf.huangli.test;

import cn.hutool.core.util.ArrayUtil;
import com.google.common.collect.Maps;
import com.xdf.huangli.util.CompareUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        List<Integer> integerList = IntStream.range(00, 24).boxed().collect(Collectors.toList());
        System.out.println(integerList);

        LinkedHashMap<String, List<Integer>> linkedHashMap = Maps.newLinkedHashMap();

        LocalDate afterDate = now.minusDays(30);

        // 获取倒数30天
        List<LocalDateTime> localDateTimes = new ArrayList<>(30);
        for (LocalDate currentdate = afterDate; currentdate.isBefore(now) || currentdate.isEqual(now); currentdate = currentdate.plusDays(1)) {
            localDateTimes.add(LocalDateTime.of(currentdate.getYear(), currentdate.getMonth(), currentdate.getDayOfMonth(), 0, 0, 0));
//            LocalDateTime time = LocalDateTime.of(currentdate.getYear(), currentdate.getMonth(), currentdate.getDayOfMonth(), 0, 0, 0);
//            linkedHashMap.put(time.format( DateTimeFormatter.ofPattern("yyyy-MM-dd")), integerList);
        }
        System.out.println(localDateTimes);

        Map<String, String> stringStringMap = getHoursByDay(localDateTimes);
    }

    /**
     * 根据年月获取每天每一小时的开始和下一小时开始时间
     *
     * @param year  年
     * @param month 月
     * @return Map<String, String> 小时开始<=date<下一小时的开始
     */
    public static Map<String, String> getHoursByDay( List<LocalDateTime> localDateTimes ) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Calendar c = Calendar.getInstance();
//        c.set(year, month, 0);
        //int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int days = c.get(Calendar.DAY_OF_MONTH);
        Map<String, String> dayHours = new TreeMap<>();
        for (LocalDateTime localDateTime : localDateTimes) {
            for (int hour = 0; hour <= 23; hour++) {
                c.set(Calendar.HOUR_OF_DAY, hour);
                c.set(Calendar.MINUTE, 0);
                c.set(Calendar.SECOND, 0);
                c.set(Calendar.MILLISECOND, 0);
                String beginHour = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +" " + sdf.format(c.getTime());
//                c.add(Calendar.HOUR, hour);
                c.set(Calendar.MINUTE, 59);
                c.set(Calendar.SECOND, 59);
                c.set(Calendar.MILLISECOND, 999);
                String endHour =  localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" " + sdf.format(c.getTime());
                dayHours.put(beginHour, endHour);
            }
        }
//        for (int day = 1; day <= days; day++) {
//            c.set(Calendar.DAY_OF_MONTH, day);

//        }
        return dayHours;
    }
}
