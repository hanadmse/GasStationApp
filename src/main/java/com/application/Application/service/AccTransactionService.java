package com.application.Application.service;

import com.application.Application.model.*;
import com.application.Application.repo.AccountTransRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccTransactionService {
    private AccountTransRepo accountTransRepo;
    private AccountHolderService accountHolderService;

    public AccTransactionService(AccountTransRepo accountTransRepo, AccountHolderService accountHolderService) {
        this.accountTransRepo = accountTransRepo;
        this.accountHolderService = accountHolderService;
    }

    public List<AccountTransaction> getAllTransactions() {
          return accountTransRepo.findAll();
    }

    public AccountTransaction getTransaction(long accTransactionId) {
        return accountTransRepo.findById(accTransactionId)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found with ID: " + accTransactionId));
    }

    @Transactional
    public List<AccountWithdrawal> addWithdrawalsAsList(ShiftIdentifier shiftIdentifier, List<AccWithdrawalsDTO> accountWithdrawals) {
        List<AccountWithdrawal> accountWithdrawalsList = new ArrayList<>();
        for (AccWithdrawalsDTO data : accountWithdrawals) {
            AccountHolder accountHolder = accountHolderService.getAccountHolderById(data.getAccountHolderId());
            BigDecimal currBalance = accountHolder.getAccBalance();
            AccountWithdrawal accountWithdrawal = new AccountWithdrawal(shiftIdentifier, accountHolder, data);
            BigDecimal updatedBalance = currBalance.subtract(accountWithdrawal.getTransactionAmount());
            accountHolder.updateAccBalance(updatedBalance);
            accountWithdrawalsList.add(accountWithdrawal);
        }
        accountTransRepo.saveAll(accountWithdrawalsList);
        return accountWithdrawalsList;
    }

    @Transactional
    public void addPayment(AccountPaymentDTO paymentDTO) {
        AccountHolder accountHolder = accountHolderService.getAccountHolderById(paymentDTO.getAccountHolderId());
        BigDecimal currBalance = accountHolder.getAccBalance();
        AccountPayment accountPayment = new AccountPayment(accountHolder, paymentDTO);
        BigDecimal updatedBalance = currBalance.add(accountPayment.getTransactionAmount());
        accountHolder.updateAccBalance(updatedBalance);
        accountTransRepo.save(accountPayment);
    }

    @Transactional
    public void updatePayment(long originalPaymentId, AccountPaymentDTO modifiedPaymentDTO) {
        AccountTransaction originalTransaction = getTransaction(originalPaymentId);
        if (originalTransaction.getTransactionType() != TransactionType.PAYMENT) {
            throw new IllegalArgumentException("Transaction with ID " + originalPaymentId + " is not a payment.");
        } else {
            deletePayment(originalPaymentId);
            addPayment(modifiedPaymentDTO);
        }
    }

    @Transactional
    public void deletePayment(long paymentId) {
        AccountTransaction originalTransaction = getTransaction(paymentId);
        if (originalTransaction.getTransactionType() == TransactionType.PAYMENT) {
            AccountHolder accountHolder = originalTransaction.getAccountHolder();
            BigDecimal currBalance = accountHolder.getAccBalance();
            BigDecimal updatedBalance = currBalance.subtract(originalTransaction.getTransactionAmount());
            accountHolder.updateAccBalance(updatedBalance);
            accountTransRepo.deleteById(paymentId);
        } else {
            throw new IllegalArgumentException("Transaction with ID " + paymentId + " is not a payment.");
        }
    }
}
