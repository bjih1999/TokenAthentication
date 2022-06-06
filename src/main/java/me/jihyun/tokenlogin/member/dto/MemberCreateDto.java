package me.jihyun.tokenlogin.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.jihyun.tokenlogin.member.Role;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class MemberCreateDto {

    @NotEmpty
    private String userId;

    @NotEmpty
    private String password;

    @NotEmpty
    private String username;

    private Role role;
}
