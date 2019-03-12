package github.aquan.springbootupload;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @Class text
 * @Description TODO
 * @Author Aquan
 * @Date 2019.3.12 17:42
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Text {

    @Test
    public static void main(String[] args) {

        /**
         * 我初次见到的写法
         */
        Consumer<String> fun = System.out::println;
        fun.accept("hello world");

        System.out.println("========================================");

        /**
         * 现在想想其实很简单，查看println方法的源码得知println是PrintStream类中的一个非静态方法
         * 因此按照方法引用的逻辑，它肯定可以使用
         * “函数式接口 变量名 = 类实例::方法名” 的方式对该方法进行引用
         *
         * 而System.out的作用肯定就是来获取PrintStream类的一个类实例,
         *
         * 验证代码如下：
         */
        PrintStream out = System.out;
        Consumer<String> fun2 = out::println;
        fun2.accept("hello beijing");


        List<String> list = Arrays.asList("java", "python", "C++","php","java");
        List<String> listResult = list.stream().collect(Collectors.toList());
        listResult.forEach(System.out::println);
    }
}
