package com.application.Application.controller;

import com.application.Application.model.AccountHolder;
import com.application.Application.service.AccountHolderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccHolderController {
    private AccountHolderService accountHolderService;

    public AccHolderController(AccountHolderService accountHolderService) {
        this.accountHolderService = accountHolderService;
    }

    @GetMapping
    public List<AccountHolder> getAllAccountHolders() {
        return accountHolderService.getAllAccountHolders();
    }

    @GetMapping("/{accId}")
    public AccountHolder getAccountHolderById(@PathVariable long accId) {
        return accountHolderService.getAccountHolderById(accId);
    }

    @PostMapping
    public void addAccountHolder(@RequestBody AccountHolder accountHolder) {
        accountHolderService.addAccountHolder(accountHolder);
    }

    @PutMapping("/{accId}")
    public void updateAccountHolder(@PathVariable long accId, @RequestBody AccountHolder modifiedAccount) {
        accountHolderService.updateAccountHolder(accId, modifiedAccount);
    }

    @DeleteMapping("/{accId}")
    public void deleteAccountHolder(@PathVariable long accId) {
        accountHolderService.deleteAccountHolder(accId);
    }


}
