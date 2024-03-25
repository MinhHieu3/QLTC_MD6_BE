package com.example.jwtspring3.service;

import com.example.jwtspring3.model.DetailWallet;

import java.util.List;

public interface DetailService extends IGeneralService<DetailWallet> {


    List<DetailWallet> findAllByWallet(Long id);

    List<DetailWallet> getDetailsByWalletId(Long walletId);
}
