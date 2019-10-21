package run.aquan.springbootmemcached;

import net.spy.memcached.MemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import run.aquan.springbootmemcached.config.MemcachedRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Class RepositoryTests
 * @Description TODO
 * @Author Aquan
 * @Date 2019/10/21 10:23
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTests {

    @Resource
    private MemcachedRunner memcachedRunner;

    @Test
    public void testSetMemcached()  {
        MemcachedClient memcachedClient = memcachedRunner.getClient();
        Map<String, Object> result = new HashMap<>();
        result.put("a", "我");
        result.put("b", "爱");
        result.put("c", "J");
        result.put("d", "a");
        result.put("e", "v");
        result.put("f", "a");

        memcachedClient.set("testkey1",1000,"1asdasd请问123");
        memcachedClient.set("testkey2",1000,"2饿123");
        memcachedClient.set("testkey3",1000,"3让同学123");
        memcachedClient.set("testkey4",1000,"4抢人头123");
        memcachedClient.set("testkey5",1000,"5屁屁123");
        memcachedClient.set("testkey6",1000,"6哼哼唧唧123");
        memcachedClient.set("testkey7", 1000, result);
    }

    @Test
    public void testGetMemcached() {
        MemcachedClient memcachedClient = memcachedRunner.getClient();
        System.out.println("***********  "+memcachedClient.get("testkey1").toString());
        System.out.println("***********  "+memcachedClient.get("testkey2").toString());
        System.out.println("***********  "+memcachedClient.get("testkey3").toString());
        System.out.println("***********  "+memcachedClient.get("testkey4").toString());
        System.out.println("***********  "+memcachedClient.get("testkey5").toString());
        System.out.println("***********  "+memcachedClient.get("testkey6").toString());
        System.out.println("***********  "+memcachedClient.get("testkey7").toString());
        Map<String, Object> testkey7 = (Map<String, Object>) memcachedClient.get("testkey7");
        System.out.println(testkey7.get("a"));

    }

}
