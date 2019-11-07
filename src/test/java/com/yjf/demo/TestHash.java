package com.yjf.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

@SpringBootTest
public class TestHash {
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Test
    public void hset() {
        redisTemplate.opsForHash().put("h1","k1","v1");
    }
    @Test
    public void hget() {
        Object res = redisTemplate.opsForHash().get("h1","k1");
        System.out.println(res);
    }
    @Test
    public void hmset() {
        Map map = new HashMap<>();
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");
        redisTemplate.opsForHash().putAll("h2",map);
    }
    @Test
    public void hmget() {
        List list = new ArrayList();
        list.add("k1");
        list.add("k2");
        list.add("k3");
        List<String> res = redisTemplate.opsForHash().multiGet("h2", list);
        for(String s:res){
            System.out.println(s);
        }
    }
    @Test
    public void keys() {
        Set<Object> res = redisTemplate.opsForHash().keys("h2");
        for(Object r:res){
            System.out.println(r);
        }
    }
    @Test
    public void del() {
        redisTemplate.opsForHash().delete("h2","k1");
    }

}
