package com.homework.banking.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "나이대 별 평균 예치금")
public class AvgDepositByAgeGroupResponse {

    @ApiModelProperty(value = "나이대")
    private int ageGroup;

    @ApiModelProperty(value = "평균 예치금")
    private long avgBalance;
}
