package com.homework.banking.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("사용자 추가 요청")
@Setter
public class UserRequest {

    @ApiModelProperty(name = "사용자 ID")
    @NotBlank(message = "ID는 필수 값입니다.")
    private String id;

    @ApiModelProperty(required = true, name = "이름")
    @NotBlank(message = "이름은 필수 값입니다.")
    private String name;

    @ApiModelProperty(required = true, name = "나이")
    @Min(value = 1, message = "나이 값은 0보다 커야합니다.")
    private int age;

}
