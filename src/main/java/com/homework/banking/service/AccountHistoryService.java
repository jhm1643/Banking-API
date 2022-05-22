package com.homework.banking.service;

import com.homework.banking.dto.request.AccountHistoryRequest;
import com.homework.banking.entity.AccountHistory;
import com.homework.banking.repository.AccountHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountHistoryService {

    private final AccountHistoryRepository accountHistoryRepository;

    public void saveAccountHistory(AccountHistoryRequest accountHistoryRequest){
        accountHistoryRepository.save(
                AccountHistory.builder()
                        .accountNumber(accountHistoryRequest.getAccountNumber())
                        .depositWithdrawFlag(accountHistoryRequest.getDepositWithdrawFlag())
                        .depositAmount(accountHistoryRequest.getDepositAmount())
                        .depositDt(LocalDate.now())
                        .build());
    }

    public List<AccountHistory> findAll(){
        return accountHistoryRepository.findAll();
    }
}
