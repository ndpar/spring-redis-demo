package com.ndpar.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repo")
public class RepoController {

    @Autowired
    private PersonRepository repo;

    @PostMapping("/")
    public Person create(@RequestBody Person person) {
        return repo.save(person);
    }

    @GetMapping("/{id}")
    public Person read(@PathVariable String id) {
        return repo.findOne(id);
    }

    @PutMapping("/")
    public void update(@RequestBody Person person) {
        repo.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }
}