package com.yjf.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TestString {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    public void set() {
        redisTemplate.opsForValue().set("key","value");
    }
    @Test
    public void get() {
        System.out.println(redisTemplate.opsForValue().get("key"));
    }
    @Test
    public void mset() {
        Map<String,String> map = new HashMap<String,String>();
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");
        redisTemplate.opsForValue().multiSet(map);
    }
    @Test
    public void mget() {
       List list = new ArrayList();
        list.add("k1");
        list.add("k2");
        list.add("k3");
        List<String> res = redisTemplate.opsForValue().multiGet(list);
        for(String r:res){
            System.out.println(r);
        }
    }
    @Test
    public void incr() {
//        redisTemplate.opsForValue().increment("k1");
        redisTemplate.opsForValue().increment("k1",10);
    }
}