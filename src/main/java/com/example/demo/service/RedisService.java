package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    public void saveRefreshToken(String key, String value) {
        redisTemplate.opsForValue().set(key, value, 86400000L, TimeUnit.MILLISECONDS);
    }

    public void saveBlackList(String key, long ttl) {
        redisTemplate.opsForValue().set(key, "logout", ttl, TimeUnit.MILLISECONDS);
    }

    public boolean isExist(String key) {
        if(key == null) return false;
        return redisTemplate.hasKey(key);
    }

    public void deleteRefreshToken(String token) {
        redisTemplate.delete(token);
    }

}
