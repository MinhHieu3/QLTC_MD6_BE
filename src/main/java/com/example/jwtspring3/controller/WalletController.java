package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.Wallet;
import com.example.jwtspring3.service.impl.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/wallets")
public class WalletController {
    @Autowired
    WalletServiceImpl walletService;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity<>(walletService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity findAllByUser(@PathVariable Long idUser) {
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
    public ResponseEntity<String> transferMoney(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam Double amount) {
        try {
            Wallet senderWallet = walletService.findById(senderId).orElse(null);
            Wallet receiverWallet = walletService.findById(receiverId).orElse(null);
            if (senderWallet != null && receiverWallet != null) {
                if (senderWallet.getMoney() >= amount) {
                    senderWallet.setMoney(senderWallet.getMoney() - amount);
                    receiverWallet.setMoney(receiverWallet.getMoney() + amount);
                    walletService.save(senderWallet);
                    walletService.save(receiverWallet);
                    return ResponseEntity.ok("Money transfer successful");
                } else {
                    return ResponseEntity.badRequest().body("Insufficient balance in sender's wallet");
                }
            } else {
                return ResponseEntity.badRequest().body("Sender's or receiver's wallet not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the transaction");
        }
    }
    @PutMapping
    public ResponseEntity saveNewMoneyValues(Long walletId, Double newMoneyValue){
        walletService.updateWalletMoney(walletId,newMoneyValue);
        return new ResponseEntity<>("Set done",HttpStatus.OK);
    }
}
