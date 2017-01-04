package com.ndpar;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Manager {

    public String get(String key) {
        return UUID.randomUUID().toString();
    }
}
