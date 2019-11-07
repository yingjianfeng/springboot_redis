package com.yjf.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
public class TestSet {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    public void sadd() {
        redisTemplate.opsForSet().add("s1", "a", "b", "c");
    }

    @Test
    public void sismember() {
        Boolean res = redisTemplate.opsForSet().isMember("s1", "b");
        System.out.println(res);
    }

    @Test
    public void spop() {
        List<String> res = redisTemplate.opsForSet().pop("s1", 2);
        for (String s : res) {
            System.out.println(s);
        }
    }

}
