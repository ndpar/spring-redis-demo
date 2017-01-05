package com.ndpar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Manager manager;

    @GetMapping("/{key}")
    public String getValue(@PathVariable String key) {
        return manager.get(key);
    }
}