package com.ndpar.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private Service service;

    @GetMapping("/{key}")
    public String getValue(@PathVariable String key) {
        return service.get(key);
    }

    @PutMapping("/{key}/{value}")
    public void putValue(@PathVariable String key, @PathVariable String value) {
        service.put(key, value);
    }

    @DeleteMapping("/{key}")
    public void deleteValue(@PathVariable String key) {
        service.remove(key);
    }
}