package com.homework.banking.controller;

import com.homework.banking.dto.response.AvgDepositByAgeGroupResponse;
import com.homework.banking.dto.response.TotalBalanceOfUserResponse;
import com.homework.banking.dto.response.TotalDepositsPerUserAccountResponse;
import com.homework.banking.service.DepositSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/homework/search/deposit")
@Api(tags = "예치금 조회 API")
public class DepositSearchController {

    private final DepositSearchService depositSearchService;

    @ApiOperation(value = "사용자의 계좌별 예치금")
    @GetMapping("/total/user/{id}")
    public ResponseEntity<List<TotalDepositsPerUserAccountResponse>> findAccountBalanceByUserId(
            @ApiParam(value = "사용자 ID")
            @PathVariable("id") String id
    ){
        return ResponseEntity.ok(depositSearchService.findAccountBalanceByUserId(id));
    }

    @ApiOperation(value = "사용자 나이대 별 평균 예치금")
    @GetMapping("/average/byAgeGroup")
    public ResponseEntity<List<AvgDepositByAgeGroupResponse>> findAvgBalanceByAgeGroup(
    ){
        return ResponseEntity.ok(depositSearchService.findAvgBalanceByAgeGroup());
    }

    @ApiOperation(value = "해당년도 예치금 총액")
    @GetMapping("/total/year/{year}")
    public ResponseEntity<Long> findTotalBalanceByYear(
            @ApiParam(value = "년도")
            @PathVariable("year") int year
    ){
        return ResponseEntity.ok(depositSearchService.findTotalBalanceByYear(year));
    }

    @ApiOperation(value = "예치금 많은 사용자 순으로 정렬된 목록")
    @GetMapping("/total/user/sortByDeposit")
    public ResponseEntity<List<TotalBalanceOfUserResponse>> findAllTotalBalanceOfUserByTerm(
            @ApiParam(value = "시작 일 (yyyy-MM-dd)")
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            @RequestParam LocalDate startDt,

            @ApiParam(value = "종료 일 (yyyy-MM-dd)")
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            @RequestParam LocalDate endDt
    ){
        return ResponseEntity.ok(depositSearchService.findAllTotalBalanceOfUserByTerm(startDt, endDt));
    }
}
