package com.example.jwtspring3.service;

import com.example.jwtspring3.model.Detail;

import java.util.List;

public interface DetailService extends IGeneralService<Detail> {
    List<Detail> findAllByAmount(Double amount);

    List<Detail> findAllByWallet(Long id);

    List<Detail> getDetailsByWalletId(Long walletId);
}
