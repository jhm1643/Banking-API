package com.homework.banking.dto.request;

import com.homework.banking.dto.type.FlagType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "계좌 내역 추가 요청")
public class AccountHistoryRequest {

    @ApiModelProperty(name = "계좌 번호", required = true)
    @NotBlank(message = "계좌 번호 값은 필수 입니다.")
    private String accountNumber;

    @ApiModelProperty(name = "입출금 여부", required = true)
    @NotBlank(message = "입출금 여부 값은 필수 입니다.")
    private FlagType depositWithdrawFlag;

    @ApiModelProperty(name = "입금액", required = true)
    @NotBlank(message = "입금액 값은 필수 입니다.")
    private Long depositAmount;
}
