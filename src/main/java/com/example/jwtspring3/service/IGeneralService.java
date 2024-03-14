package com.example.jwtspring3.service;

import com.example.jwtspring3.model.Wallet;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    T save(T t);

    Optional<T> findById(Long id);

    void remove(Long id);


}
