package me.jihyun.tokenlogin.member.service;

import me.jihyun.tokenlogin.member.dto.MemberCreateDto;
import me.jihyun.tokenlogin.member.dto.MemberUpdateDto;
import me.jihyun.tokenlogin.member.vo.MemberVO;

public interface MemberService {

    MemberVO create(MemberCreateDto memberCreateDto);

    MemberVO findOne(String id);

    MemberVO update(String id, MemberUpdateDto memberUpdateDto);

    MemberVO remove(String id, String accessToken);
}
