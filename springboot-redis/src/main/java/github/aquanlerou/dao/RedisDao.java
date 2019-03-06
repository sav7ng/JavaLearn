package github.aquanlerou.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @Class RedisDao
 * @Description TODO
 * @Author Aquan
 * @Date 2019.3.6 17:48
 * @Version 1.0
 **/
@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void  setKey(String key, String value) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(key, value, 1, TimeUnit.MINUTES);
    }

    public String getValue(String key) {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        return ops.get(key);
    }

}
