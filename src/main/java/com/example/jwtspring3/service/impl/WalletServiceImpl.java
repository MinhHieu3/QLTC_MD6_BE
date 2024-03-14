package com.example.jwtspring3.service.impl;

import com.example.jwtspring3.model.Wallet;
import com.example.jwtspring3.repository.WalletRepository;
import com.example.jwtspring3.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    WalletRepository walletRepository;

    @Override
    public Iterable<Wallet> findAll() {
        return null;
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
    public Iterable<Wallet> findAllByUser(Long id) {
        if (id != null) {
            return walletRepository.findAllByUser_Id(id);
        }
        return walletRepository.findAll();
    }
}
