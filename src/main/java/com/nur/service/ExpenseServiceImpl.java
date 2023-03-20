package com.nur.service;

import com.nur.entity.Expense;
import com.nur.repository.ExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public void addExpense(Expense expense) {
        if (expense != null){
            expenseRepository.insert(expense);
            log.info("Expense saved - %s", expense);
        }
    }

    @Override
    public String updateExpense(Expense expense, String id) {

//        Expense savedExpense = expenseRepository.findById(expense.getId())
//                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", expense.getId())));

        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()){
            Expense savedExpense = optionalExpense.get();

            savedExpense.setExpenseName(expense.getExpenseName());
            savedExpense.setExpenseCategory(expense.getExpenseCategory());
            savedExpense.setExpenseAmount(expense.getExpenseAmount());

            expenseRepository.save(savedExpense);
            return "expense updated";
        }
        else {
            return "can't update, id not found";
        }
    }

    @Override
    public Expense getExpense(String name) {

        return expenseRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by Name - %s", name)));

//        Optional<Expense> optionalExpense = expenseRepository.findByName(name);
//        if(optionalExpense.isPresent()){
//            optionalExpense.get();
//        }
//        return null;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }
}
