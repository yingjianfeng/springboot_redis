package com.yjf.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestList {
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Test
    public void lpush(){
        redisTemplate.opsForList().leftPush("l1","v");
    }
    @Test
    public void lpushall(){
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        redisTemplate.opsForList().leftPushAll("list",list);
    }
    @Test
    public void rpushall(){
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        redisTemplate.opsForList().rightPushAll("list2",list);
    }
    @Test
    public void rpop(){
        System.out.println(redisTemplate.opsForList().rightPop("list"));
    }
    @Test
    public void len(){
        System.out.println(redisTemplate.opsForList().size("list2"));
    }


}
