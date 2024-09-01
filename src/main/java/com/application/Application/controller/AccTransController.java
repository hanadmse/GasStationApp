package com.application.Application.controller;


import com.application.Application.model.*;
import com.application.Application.service.AccTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class AccTransController {
    private AccTransactionService accTransactionService;

    public AccTransController(AccTransactionService accTransactionService) {
        this.accTransactionService = accTransactionService;
    }

    @GetMapping
    public List<AccountTransaction> getAllTransactions() {
        return accTransactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public AccountTransaction getTransaction(@PathVariable long id) {
        return accTransactionService.getTransaction(id);
    }

    @PostMapping("/withdrawals")
    public void addWithdrawalsAsList(@RequestBody ShiftIdentifier shiftIdentifier, @RequestBody List<AccWithdrawalsDTO> accountWithdrawals) {
        accTransactionService.addWithdrawalsAsList(shiftIdentifier, accountWithdrawals);
    }

    @PostMapping("/payments")
    public void addPayment(@RequestBody AccountPaymentDTO payment) {
        accTransactionService.addPayment(payment);
    }

    @PutMapping("/payments/{id}")
    public void updatePayment(@PathVariable long id, @RequestBody AccountPaymentDTO modifiedPaymentDTO) {
        accTransactionService.updatePayment(id, modifiedPaymentDTO);
    }

    @DeleteMapping("/payments/{id}")
    public void deletePayment(@PathVariable long id) {
        accTransactionService.deletePayment(id);
    }


}
