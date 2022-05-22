package com.homework.banking.controller;

import com.homework.banking.dto.request.AccountHistoryRequest;
import com.homework.banking.entity.AccountHistory;
import com.homework.banking.service.AccountHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homework/account/history")
@Api(tags = "계좌 내역 API")
@RequiredArgsConstructor
public class AccountHistoryController {

    private final AccountHistoryService accountHistoryService;

    @ApiOperation(value = "계좌 내역 추가")
    @PostMapping
    public ResponseEntity<Void> saveAccount(
            @RequestBody AccountHistoryRequest accountHistoryRequest
    ){
        accountHistoryService.saveAccountHistory(accountHistoryRequest);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "계좌 내역 목록")
    @GetMapping
    public ResponseEntity<List<AccountHistory>> findAll(){
        return ResponseEntity.ok(accountHistoryService.findAll());
    }
}
