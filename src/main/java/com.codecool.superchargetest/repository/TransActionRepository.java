package com.codecool.superchargetest.repository;

import com.codecool.superchargetest.ejb.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransActionRepository extends JpaRepository<Transaction, Integer> {
}
