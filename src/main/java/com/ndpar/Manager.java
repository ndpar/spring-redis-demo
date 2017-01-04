package com.ndpar;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Manager {

    @Cacheable("keys")
    public String get(String key) {
        return UUID.randomUUID().toString();
    }
}
