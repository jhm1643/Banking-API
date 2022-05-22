package com.homework.banking.controller;

import com.homework.banking.dto.request.AccountRequest;
import com.homework.banking.entity.Account;
import com.homework.banking.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homework/account")
@Api(tags = "계좌 API")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @ApiOperation(value = "계좌 추가")
    @PostMapping
    public ResponseEntity<Void> saveAccount(
            @RequestBody AccountRequest accountRequest
    ){
        accountService.saveAccount(accountRequest);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "계좌 목록")
    @GetMapping
    public ResponseEntity<List<Account>> findAll(){
        return ResponseEntity.ok(accountService.findAll());
    }
}
