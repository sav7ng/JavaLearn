package com.github.aquan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

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

}
