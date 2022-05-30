package me.jihyun.tokenlogin.member.controller;

import me.jihyun.tokenlogin.member.dto.MemberCreateDto;
import me.jihyun.tokenlogin.member.dto.MemberUpdateDto;
import me.jihyun.tokenlogin.member.vo.MemberVO;

public interface MemberController {

    MemberVO create(String userId, MemberCreateDto memberCreateDto);

    MemberVO findOne(String id);

    MemberVO update(String id, MemberUpdateDto memberUpdateDto);

    MemberVO remove(String id, String accessToken);
}
