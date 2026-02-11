package com.project.zero_wait_back.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {

    @NotBlank(message = "이름은 필수입니다.")
    @Pattern(regexp = "^[가-힣a-zA-Z]{2,20}$", message = "이름은 한글 또는 영문 2~20자여야 합니다.")
    private String name;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "비밀번호는 대소문자 하나이상 숫자 특수문자 하나이상이 포함된 8자 이상이어야 합니다.")
    private String password;

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    @NotBlank(message = "전화번호는 필수입니다.")
    @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", message = "전화번호 형식(010-0000-0000)이 올바르지 않습니다.")
    private String phoneNumber;

}
