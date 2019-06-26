package com.github.aquan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FillingpitApplicationTests {

    // @Test
    // public void contextLoads() {
    // }

    @Test
    public void TestMath() {
        System.out.println("Math.floorMod(-13, 12) ==> " + Math.floorMod(-13, 12));
        System.out.println("Math.PI ==> " + Math.PI);
        System.out.println("Math.E ==> " + Math.E);

        // double d = 9.997d;
        // int nd = (int) d;
        // System.out.println(nd);

        double d1 = 2;
        double d2 = 1.1;
        BigDecimal bigDecimal1 = BigDecimal.valueOf(d1);
        BigDecimal bigDecimal2 = BigDecimal.valueOf(d2);
        double result = bigDecimal1.subtract(bigDecimal2).doubleValue();
        System.out.println(result);

        System.out.println(d1-d2);
    }

    @Test
    public void testInsert(){
        // 断言
        System.out.println("**********************");
        assertEquals("foo", "foo");
        assertFalse(Boolean.FALSE);
        System.out.println("**********************");
    }


    @Test
    public void bitOperation(){
        int a=15;   //二进制：1111
        int b=2;    //二进制：0010

        /*a	1	1	1	1	15
        b	0	0	1	0	2
        a&b	0	0	1	0	2
        a|b	1	1	1	1	15
        a^b	1	1	0	1	13*/

        System.out.println(a+"&"+b+"="+(a&b));
        System.out.println(a+"|"+b+"="+(a|b));
        System.out.println(a+"^"+b+"="+(a^b));
    }

    @Test
    public void day(){
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(calendar.getTime());
    }

    @Test
    public void subString(){
        String greeting = "Hello";
        String s = greeting.substring(0, 3);
        String s1 = greeting.substring(0);
        System.out.println(s);
        System.out.println(s1);

        greeting = greeting.substring(0, 3) + "p!";
        System.out.println(greeting);

        String all = String.join(" / ", "S", "M","L", "XL");
        System.out.println(all);

        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.println(cpCount);
        System.out.println(greeting.length());
    }

    @Test
    public void breakAndContinueTest(){
        for (int i=0;i<5;i++){
            if (i==3) break;
            System.out.print(i + " ");
        }
        for (int i=0;i<5;i++){
            if (i==3) continue;
            System.out.print(i + " ");
        }
    }

    @Test
    public void breakLabelTest(){
        outer:
        for (int i=0; i<5; i++){
            for (int j=0; j<6; j++){
                if (j==4){
                    break outer;
                }
                System.out.println("i = " + i + " j = " + j);
            }
        }
        System.out.println("outer!");
    }

    @Test
    public void continueLabelTest(){
        outer:
        for (int i=0; i<5; i++){
            for (int j=0; j<6; j++){
                if (j==4){
                    continue outer;
                }
                System.out.println("i = " + i + " j = " + j);
            }
        }
        System.out.println("outer!");
    }

    @Test
    public void foreachTest() {
        // String[] array = {"Aquan","Meow","miao","haha"};
        String[] array = Arrays.copyOf(new String[] {"Aquan","Meow","miao","haha"}, 10);
        for (String string : array) {
            System.out.println(string);
        }
    }

    @Test
    public void sortTest() {
        Integer[] array = {1,6,98,23,58,64,88,785,12,15,36,99,-80,0,-5,-3};
        Arrays.sort(array);
        for (Integer integer : array) {
            System.out.print(integer + ",");
        }
    }

    @Test
    public void binarySearchTest() {
        Integer[] array = {1,6,98,23,58,64,88,785,12,15,36,99,-80,0,-5,-3};
        // int[] array = new int[] {5,8,6,7,2,9,1,0};
        //使用binarySearch的前提是数组是有序的
        Arrays.sort(array);
        System.out.println("数组是: "+ Arrays.toString(array));
        System.out.println("6对应的下标是：" + Arrays.binarySearch(array, 6));
        System.out.println("3对应的下标是：" + Arrays.binarySearch(array, 3));
        System.out.println("4对应的下标是：" + Arrays.binarySearch(array, 4));
        System.out.println("9对应的下标是：" + Arrays.binarySearch(array, 9));
        System.out.println("-1对应的下标是：" + Arrays.binarySearch(array, -1));
        System.out.println("-5对应的下标是：" + Arrays.binarySearch(array, -5));


        System.out.println("0对应的下标是：" + Arrays.binarySearch(array, 0, 16,0));
    }

    @Test
    public void localDateTest() {
        // 获取今天的日期
        LocalDate today = LocalDate.of(2019, 1, 1);
        System.out.println("today ==> " + today.toString());
        System.out.println("程序员日每年的第256天 ^_^ ==> " + today.plusDays(255));//程序员日每年的第256天 ^_^
        System.out.println("withDayOfMonth修改当前的月的天数修改为6天 ==> " + today.withDayOfMonth(6));
        System.out.println("withDayOfMonth修改当前的月份修改为8月份 ==> " + today.withMonth(8));
        System.out.println("withDayOfYear修改当年中的天数为第5天 ==> " + today.withDayOfYear(5));
        System.out.println("withYear修改当前日期的年为指定的2020年 ==> " + today.withYear(2020));

        // 今天是几号
        int dayofMonth = today.getDayOfMonth();
        // 今天是周几（返回的是个枚举类型，需要再getValue()）
        int dayofWeek = today.getDayOfWeek().getValue();
        // 今年是哪一年
        int dayofYear = today.getDayOfYear();
        System.out.println(dayofMonth + "|" + dayofWeek + "|" + dayofYear);
        // {@code 1}MONDAY
        // {@code 2}TUESDAY
        // {@code 3}WEDNESDAY
        // {@code 4}THURSDAY
        // {@code 5}FRIDAY
        // {@code 6}SATURDAY
        // {@code 7}SUNDAY


        LocalDate today2 = LocalDate.parse("2020-09-09");
        int years = today.until(today2).getYears();
        int months = today.until(today2).getMonths();
        int days = today.until(today2).getDays();
        System.out.println(today + " 和 " + today2 + " 间隔 ==> " + years + " years, " + months + " months and " + days + " days");

        long year = today.until(today2, ChronoUnit.YEARS);
        long month = today.until(today2, ChronoUnit.MONTHS);
        long day = today.until(today2, ChronoUnit.DAYS);
        System.out.println(today + " 和 " + today2 + " 间隔 ==> " + year + "年");
        System.out.println(today + " 和 " + today2 + " 间隔 ==> " + month + "月");
        System.out.println(today + " 和 " + today2 + " 间隔 ==> " + day + "天");

        System.out.println(today + " 在 " + today2 + " 之前？ ==> " + today.isBefore(today2));
        System.out.println(today + " 在 " + today2 + " 之后？ ==> " + today.isAfter(today2));

        System.out.println(today + " 是闰年吗？ ==> " + today.isLeapYear());


        // 根据字符串取：
        LocalDate endOfFeb = LocalDate.parse("2019-10-24");
        System.out.println(endOfFeb.toString());
        // 严格按照yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式

        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        // 取2019年1月第一个周一
        LocalDate firstMondayOf2019 = LocalDate.parse("2019-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println("取本月第1天 ==> " + firstDayOfThisMonth);
        System.out.println("取本月最后一天，再也不用计算是28，29，30还是31 ==> " + lastDayOfThisMonth);
        System.out.println("取2019年1月第一个周一 ==> " + firstMondayOf2019);

    }


    @Test
    public void CalendarTest() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        date = date.minusDays(today - 1); // Set to start of month
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++)
            System.out.print("    ");
        while (date.getMonthValue() == month)
        {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1) System.out.println();
    }

    @Test
    public void PrimitiveTypeTest() {
        // byte
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();

        // short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();

        // int
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();

        // long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();

        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE="
                + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE="
                + (int) Character.MAX_VALUE);
    }

}
