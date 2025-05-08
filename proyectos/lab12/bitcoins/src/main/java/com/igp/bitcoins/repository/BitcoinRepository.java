package com.igp.bitcoins.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igp.bitcoins.entities.Bitcoin;

public interface BitcoinRepository extends JpaRepository<Bitcoin, Long>{
    Bitcoin findByIdCuenta(Long idCuenta);
}
