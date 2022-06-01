package me.jihyun.tokenlogin.member.vo;

import lombok.Getter;
import me.jihyun.tokenlogin.member.Member;

@Getter
public class MemberVO {

    private Long id;

    private String userId;

    public MemberVO(Member member) {
        this.id = member.getId();
        this.userId = member.getUserId();
    }
}
