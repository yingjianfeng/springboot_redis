package com.yjf.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

@SpringBootTest
public class TestZSet {
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Test
    public void zadd() {
        redisTemplate.opsForZSet().add("z1","a",10);
        redisTemplate.opsForZSet().add("z1","b",21);
        redisTemplate.opsForZSet().add("z1","c",20);
    }
    @Test
    public void zscore() {
        Double score = redisTemplate.opsForZSet().score("z1", "c");
        System.out.println(score);
    }
    @Test
    public void zrange() {
        Set<String> res = redisTemplate.opsForZSet().range("z1", 0, -1);
        System.out.println(res);
    }


}
