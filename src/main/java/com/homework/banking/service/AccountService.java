package com.homework.banking.service;

import com.homework.banking.dto.request.AccountRequest;
import com.homework.banking.entity.Account;
import com.homework.banking.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    private final UserService userService;

    public void saveAccount(AccountRequest accountRequest){
        accountRepository.save(
                Account.builder()
                        .accountNumber(accountRequest.getAccountNumber())
                        .userId(accountRequest.getUserId())
                        .build());
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }
}
