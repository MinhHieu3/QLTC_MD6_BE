package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.DetailWallet;
import com.example.jwtspring3.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/details")
public class DetailWalletController {
    @Autowired
    private DetailService detailService;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity<>(detailService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody DetailWallet detail) {
        return new ResponseEntity<>(detailService.save(detail), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody DetailWallet detail) {
        detail.setId(id);
        return new ResponseEntity<>(detailService.save(detail), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        detailService.remove(id);
        return new ResponseEntity<>("Delete done", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findAllByWallet(@PathVariable Long id) {
        return new ResponseEntity<>(detailService.findAllByWallet(id), HttpStatus.OK);
    }
}
