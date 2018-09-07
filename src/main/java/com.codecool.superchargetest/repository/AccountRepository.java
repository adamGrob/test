package com.codecool.superchargetest.repository;

import com.codecool.superchargetest.ejb.Account;
import com.codecool.superchargetest.ejb.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "update account" +
            " set balance = balance + :transferAmount" +
            "  where id = :accountIdToChangeBalance", nativeQuery = true)
    void changeBalance(@Param("transferAmount") Integer transferAmount, BigDecimal accountIdToChangeBalance);


}
