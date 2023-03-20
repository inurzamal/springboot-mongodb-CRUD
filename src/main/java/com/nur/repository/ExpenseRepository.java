package com.nur.repository;

import com.nur.entity.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

    @Query("{'name': ?0}")
    Optional<Expense> findByName(String name);

    @Query("{'name': ?0, 'amount': ?1}")
    Optional<Expense> findByNameAndAmount(String name, BigDecimal amount);
}
