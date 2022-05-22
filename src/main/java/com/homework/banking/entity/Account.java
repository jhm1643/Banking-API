package com.homework.banking.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "account")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Account {

    @Id
    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "user_id")
    private String userId;
}
