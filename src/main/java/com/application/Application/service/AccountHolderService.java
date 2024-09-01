package com.application.Application.service;

import com.application.Application.model.AccountHolder;
import com.application.Application.repo.AccountHolderRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountHolderService {

    private AccountHolderRepo accountHolderRepo;

    public AccountHolderService(AccountHolderRepo accountHolderRepo) {
        this.accountHolderRepo = accountHolderRepo;
    }

    public List<AccountHolder> getAllAccountHolders() {
        return accountHolderRepo.findAll();
    }

    public AccountHolder getAccountHolderById(long id) {
        return accountHolderRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("AccountHolder with ID " + id + " not found"));
    }

    public void addAccountHolder(AccountHolder accountHolder) {
        accountHolderRepo.save(accountHolder);
    }

    public void updateAccountHolder(long accId, AccountHolder modifiedAccount) {
        if (!accountHolderRepo.existsById(accId)) { {
            throw new IllegalArgumentException("AccountHolder with ID " + accId + " not found");
        }
        } else {
            deleteAccountHolder(accId);
            addAccountHolder(modifiedAccount);
        }
    }

    public void deleteAccountHolder(long id) {
        if (!accountHolderRepo.existsById(id)) { {
            throw new IllegalArgumentException("AccountHolder with ID " + id + " not found");
        }
        } else {
            accountHolderRepo.deleteById(id);
        }
    }
}
