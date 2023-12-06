package com.captainx.learningBackup.并发.Async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;

/**
 * @Author: xuchengrui
 * @Date: 2023/12/6
 * @Description:测试异步注解效果
 **/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AsyncTest {

    @Autowired
    private AsyncClient asyncClient;

    @Test
    public void testAsyncMethods() throws ExecutionException, InterruptedException {

        asyncClient.performAsyncTasks();

    }
}
