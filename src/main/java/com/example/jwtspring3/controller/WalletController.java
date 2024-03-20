package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.Wallet;
import com.example.jwtspring3.service.impl.WalletServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("users/wallets")
public class WalletController {
    @Autowired
    WalletServiceImpl walletService;

    @GetMapping("/{idUser}")
    public ResponseEntity findAll(@PathVariable Long idUser) {
        return new ResponseEntity<>(walletService.findAllByUser(idUser), HttpStatus.OK);
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
    @PostMapping("/transfer")
    public ResponseEntity transferMoney(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam Double amount) {
        Wallet senderWallet = walletService.findById(senderId).orElse(null);
        Wallet receiverWallet = walletService.findById(receiverId).orElse(null);

        if (senderWallet != null && receiverWallet != null && senderWallet.getMoney() >= amount) {
            senderWallet.setMoney(senderWallet.getMoney() - amount);
            walletService.save(senderWallet);

            receiverWallet.setMoney(receiverWallet.getMoney() + amount);
            walletService.save(receiverWallet);

            return new ResponseEntity<>("Money transfer successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Money transfer failed. Please check your input and try again.", HttpStatus.BAD_REQUEST);
        }
    }


}
