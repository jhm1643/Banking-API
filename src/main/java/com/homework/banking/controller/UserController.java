package com.homework.banking.controller;

import com.homework.banking.dto.request.UserRequest;
import com.homework.banking.entity.User;
import com.homework.banking.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/homework/user")
@Api(tags = "사용자 API")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "사용자 추가")
    @PostMapping
    public ResponseEntity<Void> saveUser(
            @Valid
            @RequestBody UserRequest userRequest
    ){
        userService.saveUser(userRequest);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "사용자 목록")
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
}
