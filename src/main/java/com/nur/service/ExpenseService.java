package com.nur.service;

import com.nur.entity.Expense;

import java.util.List;

public interface ExpenseService {

//     Add Expense
//     Update Expense
//     Get Expense by Name
//     Get All Expenses
//     Delete Expense

    public void addExpense(Expense expense);
    public String updateExpense(Expense expense, String id);
    public Expense getExpense(String name);
    public List<Expense> getAllExpenses();
    public void deleteExpense(String id);
}
