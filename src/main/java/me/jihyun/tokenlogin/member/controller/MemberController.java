package me.jihyun.tokenlogin.member.controller;

import me.jihyun.tokenlogin.member.dto.MemberCreateDto;
import me.jihyun.tokenlogin.member.dto.MemberUpdateDto;
import me.jihyun.tokenlogin.member.vo.MemberVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.net.URISyntaxException;

public interface MemberController {
    ResponseEntity<MemberVO> create(@RequestBody @Valid MemberCreateDto memberCreateDto) throws URISyntaxException;

    MemberVO findOne(Long id);

    MemberVO update(Long id, MemberUpdateDto memberUpdateDto);

    MemberVO remove(Long id, String accessToken);
}
