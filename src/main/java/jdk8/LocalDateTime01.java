package jdk8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * 演示JDK1.8新日期：LocalDateTime等相关API
 *
 * @author java@Wqy
 * @version 0.0.1
 * @since 2023.1.5
 */
public class LocalDateTime01 {
    public static void main(String args[]){
        LocalDateTime01 java8tester = new LocalDateTime01();
        java8tester.testLocalDateTime();
    }

    public void testLocalDateTime(){

        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);// 2023-01-05T12:04:45.295

        // 转化本地时间: toLocalDate()方法
        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1); // 2023-01-05

        // 获取月份: getMonth()方法
        Month month = currentTime.getMonth();
        // 获取日: getDayOfMonth()方法
        int day = currentTime.getDayOfMonth();
        // 获取秒: getSecond()方法
        int seconds = currentTime.getSecond();

        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);

        // 根据指定年月获取东八区时间: withDayOfMonth()/withYear()
        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }
}
