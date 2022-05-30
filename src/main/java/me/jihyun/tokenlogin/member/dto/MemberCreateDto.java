package me.jihyun.tokenlogin.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberCreateDto {

    private String userId;

    private String password;

    private String username;
}
