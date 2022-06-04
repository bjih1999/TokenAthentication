package me.jihyun.tokenlogin.authToken.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class LoginDto {

    @NotEmpty
    private String userId;

    @NotEmpty
    private String password;
}
