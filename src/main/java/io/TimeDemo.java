package io;

public class TimeDemo {
    public static void main(String[] args) {
        //UTC:世界协调时
        //long返回的是自1970年1月1日00:00:00到当前系统时间经过的毫秒值
        long now = System.currentTimeMillis();//到现在的时间ms
        System.out.println(now);//输出现在的时间ms
        System.out.println(now/1000/60/60/24/365);//转化成年份

        long max = Long.MAX_VALUE;//用long的包装类Long来获取long的最大值
        max = max/1000/60/60/24/365;//将long的最大值转化成年份
        System.out.println("公元:"+(1970+max));//输出从1970与long年份最大值的和
    }
}
