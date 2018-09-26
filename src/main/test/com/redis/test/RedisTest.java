package com.redis.test;

import com.redis.test.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 下午5:19 2018/9/25
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/spring-redis.xml")
public class RedisTest {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void set(){
        Map<String,String> user = new HashMap<>();
        user.put("name","lian");
        user.put("age","23");
        user.put("sex","男");

        redisUtil.set("1",user);
    }

    @Test
    public void get(){
        Map<String,String> user = (HashMap)redisUtil.get("1");
        System.out.println(user);
    }
}
