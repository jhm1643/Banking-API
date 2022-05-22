package com.homework.banking.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "기간 내 사용자 별 예치금 목록")
public class TotalBalanceOfUserResponse {

    @ApiModelProperty(value = "사용자 ID")
    private String id;

    @ApiModelProperty(value = "사용자 이름")
    private String name;

    @ApiModelProperty(value = "총 예치금")
    private long totalBalance;
}
