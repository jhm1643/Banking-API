package com.homework.banking.dto.request;

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
@ApiModel(value = "계좌 추가 요청")
public class AccountRequest {

    @ApiModelProperty(name = "사용자 ID", required = true)
    @NotBlank(message = "사용자 ID 값은 필수 입니다.")
    private String userId;

    @ApiModelProperty(name = "계좌 번호", required = true)
    @NotBlank(message = "계좌 번호 값을 필수 입니다.")
    private String accountNumber;
}
