package com.example.mybatisexample;

import com.example.mybatisexample.entity.Account;
import com.example.mybatisexample.example07.AccountService07;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
@Slf4j
public class AccountMapperTest {
    @Autowired
    private AccountService07 accountService07;

    @Test
    public void buy_test() throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();
        int count = 2;
        CountDownLatch latch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            service.execute(()->{
                        try {
                            Thread.sleep(1000);
                            Account a = accountService07.buy(1,600);
                            log.debug(a.getName());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            latch.countDown();
                        }
                    });
        }
        latch.await();
        service.shutdown();
    }



}
