package com.example.jwtspring3.service;

import com.example.jwtspring3.model.Wallet;

public interface WalletService extends IGeneralService<Wallet> {
    Iterable<Wallet> findAllByUser(Long id);
}
