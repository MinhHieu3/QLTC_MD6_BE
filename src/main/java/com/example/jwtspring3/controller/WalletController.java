package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.Wallet;
import com.example.jwtspring3.service.impl.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/wallets")
public class WalletController {
    @Autowired
    WalletServiceImpl walletService;

    @GetMapping
    public ResponseEntity findAll(Long id, String name) {
        return new ResponseEntity<>(walletService.findAll(id, name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Wallet wallet) {
        return new ResponseEntity<>(walletService.save(wallet), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity save(@PathVariable Long id, @RequestBody Wallet wallet) {
        wallet.setId(id);
        return new ResponseEntity<>(walletService.save(wallet), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        walletService.remove(id);
        return new ResponseEntity<>("Delete done", HttpStatus.OK);
    }

    @GetMapping("/{id}/findById")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity<>(walletService.findById(id), HttpStatus.OK);
    }

}
