package com.homework.banking.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "사용자 계좌별 예치금")
public class TotalDepositsPerUserAccountResponse {

    @ApiModelProperty(value = "계좌 번호")
    private String accountNumber;

    @ApiModelProperty(value = "총 예치금")
    private Long totalBalance;
}
