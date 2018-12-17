package cn.eunji.aquan.factory;

import org.jboss.logging.Param;

/**
 * @Class MathTest
 * @Description TODO
 * @Author Aquan
 * @Date 2018.12.17 17:42
 * @Version 1.0
 **/
public class MathTest {


    /**
     * 假设你月收入是3000，除开平时花销，每个月留下1000块钱进行投资。
     *
     * 然后你认真的钻研了 《股票和基金 21天从入门到精通》，达到了每年20%的投资回报率。
     *
     * 那么问题来了，以每个月投资1000块钱的节奏，持续投资多少年，总收入达到100万
     * （复利计算按照每年12000投入计算，不按照每月计息）
     *
     * 复利公式：
     * F = p* ( (1+r)^n );
     * F 最终收入
     * p 本金
     * r 年利率
     * n 存了多少年
     *
     * 假设情景一：
     * p = 10000
     * r = 0.05
     * n = 1
     *
     * 解读：
     * 本金是10000
     * 年利率是5%
     * 存了一年 1次
     * 复利收入 10000*( (1+0.05)^1 ) = 10500
     *
     * 假设情景二：
     * p = 10000
     * r = 0.05
     * n = 2
     *
     * 解读：
     * 本金是10000
     * 年利率是5%
     * 存了两年
     * 复利收入 10000*( (1+0.05)^2 ) = 11025
     **/


    public static void main(String[] args) {
        int fundPerMonth = 1000;
        int fundPerYear = fundPerMonth *12;
        float rate = 0.20f;
        //F = p* ( (1+r)^n );
        int sum = 0;
        int target = 1000*1000;
        for (int j = 1; j < 100; j++) {
            int year = j;
            float compoundInterestRate = 1;
            for (int i = 0; i < year; i++) {
                compoundInterestRate = compoundInterestRate * (1+rate);
            }
            int compoundInterest = (int) (fundPerYear * compoundInterestRate);

            System.out.println("第" + year + " 年， 收益 " + compoundInterest);
            sum +=compoundInterest;
            // System.out.println("经过" + year + " 年， 总收入 " + sum);
            if(sum>=target){
                System.out.println("一共需要" + year + "年，累计收入超过" + target );
                break;
            }
        }

    }


}
