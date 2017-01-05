package com.ndpar.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Service {

    @Cacheable("keys")
    public String get(String key) {
        return UUID.randomUUID().toString();
    }

    @CachePut(cacheNames = "keys", key = "#key")
    public String put(String key, String value) {
        return value;
    }

    @CacheEvict(cacheNames = "keys", key = "#key")
    public void remove(String key) {
        // do nothing
    }
}
