package com.homework.banking.mapper;

import com.homework.banking.dto.response.AvgDepositByAgeGroupResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BalanceSearchMapper {

    List<AvgDepositByAgeGroupResponse> findAllAvgBalanceByAgeGroup();
    List<Long> findTotalBalanceByYear();
}
