package com.example.demo2;

import com.example.Service.impl.UsersServiceImpl;
import com.example.entity.users.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    //操作的是复杂类型，User
    @Autowired
    RedisTemplate redisTemplate;

    //针对 的都是操作字符串
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //自定义json序列化器
    @Autowired
    RedisTemplate jsonRedisTemplate;
    @Autowired
    UsersServiceImpl usersService;

    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 五大数据类型
     stringRedisTemplate.opsForValue();//操作字符串
     stringRedisTemplate.opsForHash();//操作map
     stringRedisTemplate.opsForList();//操作list
     stringRedisTemplate.opsForSet();//操作set
     stringRedisTemplate.opsForZSet();//操作zset
     **/
    @Test
    public void contextLoads() {
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");
        stringRedisTemplate.opsForValue().set("age","123");
//        String name = stringRedisTemplate.opsForValue().get("name");
//        String age = stringRedisTemplate.opsForValue().get("age");
//        System.out.println(name);
//        System.out.println(age);
//        stringRedisTemplate.opsForList().leftPush("list","a");
//        stringRedisTemplate.opsForList().leftPushAll("list","b","c","d");
        List <String> list = stringRedisTemplate.opsForList().range("list", 0, -1);
        System.out.println(list);
    }
    @Test
    public void TestRedis(){
        User user = usersService.getById(1);
        jsonRedisTemplate.opsForValue().set("users",user);
        Object users1 = jsonRedisTemplate.opsForValue().get("users");
        System.out.println(user);

    }
}
