package com.example.jwtspring3.repository;

import com.example.jwtspring3.model.DetailWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<DetailWallet,Long> {
    List<DetailWallet> findAllByWallet_Id(Long id);

}
