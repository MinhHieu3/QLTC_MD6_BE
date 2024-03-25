package com.example.jwtspring3.service;

import com.example.jwtspring3.model.Wallet;

import java.util.List;


public interface WalletService extends IGeneralService<Wallet> {
    List<Wallet> findAllByUser(Long id);
    void updateWalletMoney(Long walletId, Double newMoneyValue);
    List<Wallet> findByUserId(Long userId);
    void deleteAllByUserId(Long userId);

}
