package com.example.jwtspring3.repository;

import com.example.jwtspring3.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
    List<Wallet>findAllByUser_Id (Long id);

}
