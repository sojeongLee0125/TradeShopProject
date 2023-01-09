package com.nfteam.server.member.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberPostDto {
    @Email
    @NotBlank(message = "이메일은 필수값 입니다.")
    private String email;

    @NotBlank(message = "이름을 정해주세요")
    private String nickname;

    @NotBlank(message = "비밀번호를 정해주세요")
    private String password;

}
