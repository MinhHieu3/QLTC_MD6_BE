package com.example.jwtspring3.service;

import com.example.jwtspring3.model.Wallet;

public interface WalletService extends IGeneralService<Wallet> {
    @Override
    Iterable<Wallet> findAll(Long id, String name);
}
