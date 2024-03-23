package com.example.jwtspring3.repository;

import com.example.jwtspring3.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail,Long> {
    List<Detail> findAllByWallet_Id(Long id);

    List<Detail> findAllByAmount(Double amount);
}
