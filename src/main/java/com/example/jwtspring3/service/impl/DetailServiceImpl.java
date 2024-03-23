package com.example.jwtspring3.service.impl;

import com.example.jwtspring3.model.Detail;
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
    public List<Detail> findAllByAmount(Double amount) {
        return detailRepository.findAllByAmount(amount);
    }

    @Override
    public Iterable<Detail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public Detail save(Detail detail) {
        return detailRepository.save(detail);
    }

    @Override
    public Optional<Detail> findById(Long id) {
        return detailRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        detailRepository.deleteById(id);
    }

    @Override
    public List<Detail> findAllByWallet(Long id) {
        if (id != null) {
            return detailRepository.findAllByWallet_Id(id);
        } else {
            return detailRepository.findAll();
        }
    }

    @Override
    public List<Detail> getDetailsByWalletId(Long walletId) {
        return null;
    }
}

