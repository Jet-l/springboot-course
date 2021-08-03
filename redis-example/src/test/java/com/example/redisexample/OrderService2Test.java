package com.example.redisexample;

import com.example.redisexample.entity.Item;
import com.example.redisexample.entity.User;
import com.example.redisexample.service.OrderService02;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.CountDownLatch;

@SpringBootTest
@Slf4j
public class OrderService2Test {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private OrderService02 orderService02;

    @Test
    public void test() {
        // 添加一个商品的抢购活动。置于redis
        Item item = Item.builder().id(1L).total(100).build();
        orderService02.addActivity(item);
        // 查询
        HashOperations<String, Long, Integer> ho = redisTemplate.opsForHash();
        log.debug("插入的数量: {}", ho.get("items", item.getId()));
    }
    @Test
    public void test1() throws InterruptedException {
        // 模拟并发抢购人数
        int count = 20_000;
        // 模拟抢购商品信息
        Item item = Item.builder().id(1L).total(100).build();
        final Logic logic = new Logic();
        CountDownLatch latch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                if (orderService02.addOrder(new User(), item)) {
                    // 统计抢到的数量
                    logic.increment();
                }
                latch.countDown();
            }).start();
        }
        latch.await();
        HashOperations<String, Long, Integer> ho = redisTemplate.opsForHash();
        log.debug("商品被抢购数量：{}", logic.getCount());
        log.debug("商品总抢购人数：{}", count);
    }

    // 辅助获取执行计数
    private static class Logic {
        int count;

        public int getCount() {
            return count;
        }

        public synchronized void increment() {
            count++;
        }
    }
}
