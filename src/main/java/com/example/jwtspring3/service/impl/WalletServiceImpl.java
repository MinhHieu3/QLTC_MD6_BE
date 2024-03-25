package com.example.jwtspring3.service.impl;

import com.example.jwtspring3.model.Wallet;
import com.example.jwtspring3.repository.WalletRepository;
import com.example.jwtspring3.service.WalletService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class WalletServiceImpl implements WalletService {
    @Autowired
    WalletRepository walletRepository;

    @Override
    public Iterable<Wallet> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Optional<Wallet> findById(Long id) {
        return walletRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        walletRepository.deleteById(id);
    }


    @Override
    public List<Wallet> findAllByUser(Long id) {
        if (id != null) {
            return walletRepository.findAllByUser_Id(id);
        } else {
            return walletRepository.findAll();
        }
    }

    @Override
    public void updateWalletMoney(Long walletId, Double newMoneyValue) {
        Optional<Wallet> walletOptional = walletRepository.findById(walletId);
        Wallet wallet = walletOptional.get();
        wallet.setMoney(newMoneyValue);
        walletRepository.save(wallet);
    }

    @Override
    public List<Wallet> findByUserId(Long userId) {
        return walletRepository.findByUserId(userId);
    }

    @Override
    public void deleteAllByUserId(Long userId) {
        walletRepository.deleteAllByUserId(userId);

    }
}
