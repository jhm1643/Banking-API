package com.homework.banking.entity;

import com.homework.banking.dto.type.FlagType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "account_history")
@SequenceGenerator(
        name = "account_history_seq_generator",
        sequenceName = "account_history_seq",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_history_seq_generator")
    @Column(name = "id")
    private long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "deposit_withdraw_flag")
    @Enumerated(EnumType.STRING)
    private FlagType depositWithdrawFlag;

    @Column(name = "deposit_amount")
    private long depositAmount;

    @Column(name = "deposit_dt")
    private LocalDate depositDt;
}
