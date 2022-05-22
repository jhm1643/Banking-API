package com.homework.banking.service;

import com.homework.banking.dto.response.AvgDepositByAgeGroupResponse;
import com.homework.banking.dto.response.TotalBalanceOfUserResponse;
import com.homework.banking.dto.response.TotalDepositsPerUserAccountResponse;
import com.homework.banking.mapper.BalanceSearchMapper;
import com.homework.banking.repository.querydsl.BalanceSearchQuerdsl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepositSearchService {

    private final BalanceSearchQuerdsl balanceSearchQuerdsl;
    private final BalanceSearchMapper balanceSearchMapper;

    public List<TotalDepositsPerUserAccountResponse> findAccountBalanceByUserId(String userId){
        return balanceSearchQuerdsl.findAccountBalanceByUserId(userId);
    }

    public List<AvgDepositByAgeGroupResponse> findAvgBalanceByAgeGroup(){
        return balanceSearchMapper.findAllAvgBalanceByAgeGroup();
    }

    public Long findTotalBalanceByYear(int year){
        return balanceSearchQuerdsl.findTotalBalanceByYear(year);
    }

    public List<TotalBalanceOfUserResponse> findAllTotalBalanceOfUserByTerm(LocalDate startDt, LocalDate endDt){
        return balanceSearchQuerdsl.findAllTotalBalanceOfUserByTerm(startDt, endDt);
    }
}
