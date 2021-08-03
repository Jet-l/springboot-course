package com.example.redisexample.service;

import com.example.redisexample.entity.Item;
import com.example.redisexample.entity.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Slf4j
public class OrderService02 {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, Integer> ho;

    private DefaultRedisScript<Boolean> redisScript;
    // redis中key
    private String key = "items";

    @PostConstruct
    public void init() {
        ho = redisTemplate.opsForHash();
        redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(Boolean.class);
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("order.lua")));
    }

    // 在创建抢购活动时，从数据库提取商品ID/抢购数量等信息，提前置于redis
    public void addActivity(Item item) {
        ho.put(key, item.getId(), item.getTotal());

    }
    // 执行lua脚本可通过设置标识，整合返回更多信息
    public boolean addOrder(User user, Item item) {
        if (!ho.hasKey(key, item.getId())) {
            log.debug("商品不存在");
            return false;
        }
        boolean a = redisTemplate.execute(redisScript, List.of(key), item.getId());
        if (!a) {
            //log.debug("商品已被抢光");
            return false;
        }
        // 抢购成功，执行创建订单等操作
        // 商品已经抢到，为减轻服务器/数据库压力，可以将订单处理操作发送至消息队列异步处理

        return true;
    }
}
