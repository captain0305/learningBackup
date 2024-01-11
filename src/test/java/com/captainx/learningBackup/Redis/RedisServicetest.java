package com.captainx.learningBackup.Redis;

/**
 * @Author: xuchengrui
 * @Date: 2024/1/3
 * @Description:test
 **/
import com.captainx.learningBackup.Redis.springdataredis.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(properties = "logging.level.io.lettuce.core=DEBUG")
public class RedisServicetest {

    @Autowired
    private RedisService redisService;

    @Test
    public void testSetValueAndGetValue() {
        String key = "testaaa";
        String value = "testValueaaa";

        // Set a value in Redis
        redisService.setValue(key, value);

        // Retrieve the value from Redis
        String retrievedValue = redisService.getValue(key);
        System.out.println(retrievedValue);

        // Assert that the retrieved value is equal to the original value
        assertEquals(value, retrievedValue);
    }

    @Test
    public void testDeleteKey() {
        String key = "key";
        String value = "testValue";

        // Set a value in Redis
        redisService.setValue(key, value);

        // Delete the key from Redis
        redisService.deleteKey(key);

        // Retrieve the value from Redis after deletion
        String retrievedValue = redisService.getValue(key);

        // Assert that the retrieved value is null after deletion
        assertEquals(null, retrievedValue);
    }
}
