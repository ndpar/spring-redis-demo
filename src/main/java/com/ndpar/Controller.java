package com.ndpar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private Manager manager;

    @GetMapping("/{key}")
    public String getValue(@PathVariable String key) {
        return manager.get(key);
    }

    @PutMapping("/{key}/{value}")
    public void putValue(@PathVariable String key, @PathVariable String value) {
        manager.put(key, value);
    }

    @DeleteMapping("/{key}")
    public void deleteValue(@PathVariable String key) {
        manager.remove(key);
    }
}