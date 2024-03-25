package com.example.jwtspring3.service.impl;

import com.example.jwtspring3.model.DetailWallet;
import com.example.jwtspring3.repository.DetailRepository;
import com.example.jwtspring3.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    DetailRepository detailRepository;

    @Override
    public Iterable<DetailWallet> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public DetailWallet save(DetailWallet detail) {
        return detailRepository.save(detail);
    }

    @Override
    public Optional<DetailWallet> findById(Long id) {
        return detailRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        detailRepository.deleteById(id);
    }

    @Override
    public List<DetailWallet> findAllByWallet(Long id) {
        if (id != null) {
            return detailRepository.findAllByWallet_Id(id);
        } else {
            return detailRepository.findAll();
        }
    }

    @Override
    public List<DetailWallet> getDetailsByWalletId(Long walletId) {
        return null;
    }
}

