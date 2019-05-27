package com.github.aquan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.math.BigDecimal;

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


        StrictMath.PI
    }

    @Test
    public void testInsert(){
        // 断言
        System.out.println("**********************");
        assertEquals("foo", "foo");
        assertFalse(Boolean.FALSE);
        System.out.println("**********************");
    }


}
