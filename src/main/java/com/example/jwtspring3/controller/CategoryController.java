package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.Category;
import com.example.jwtspring3.model.Wallet;
import com.example.jwtspring3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity save(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity save(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        categoryService.remove(id);
        return new ResponseEntity<>("Delete done", HttpStatus.OK);
    }
}
