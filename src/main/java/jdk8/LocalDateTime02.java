package jdk8;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 演示面对时区时的问题: ZonedDateTime
 *
 * @author Java@Wqy
 * @version 0.0.1
 * @since 2023.1.5
 */
public class LocalDateTime02 {
    // 如果我们需要考虑到时区，就可以使用时区的日期时间API
    public static void main(String args[]){
        LocalDateTime02 java8tester = new LocalDateTime02();
        java8tester.testZonedDateTime();
    }

    public void testZonedDateTime(){

        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);// 2015-12-03T10:15:30+08:00[Asia/Shanghai]

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);// Europe/Paris

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);// Asia/Shanghai
    }
}
