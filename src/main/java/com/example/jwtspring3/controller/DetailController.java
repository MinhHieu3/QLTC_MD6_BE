package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.Detail;
import com.example.jwtspring3.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/details")
public class DetailController {
    @Autowired
    private DetailService detailService;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity<>(detailService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Detail detail) {
        return new ResponseEntity<>(detailService.save(detail), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Detail detail) {
        detail.setId(id);
        return new ResponseEntity<>(detailService.save(detail), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        detailService.remove(id);
        return new ResponseEntity<>("Delete done", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity<>(detailService.findById(id), HttpStatus.OK);
    }
}
