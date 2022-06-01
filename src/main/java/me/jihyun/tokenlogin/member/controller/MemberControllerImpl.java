package me.jihyun.tokenlogin.member.controller;

import lombok.RequiredArgsConstructor;
import me.jihyun.tokenlogin.member.dto.MemberCreateDto;
import me.jihyun.tokenlogin.member.dto.MemberUpdateDto;
import me.jihyun.tokenlogin.member.service.MemberService;
import me.jihyun.tokenlogin.member.vo.MemberVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberControllerImpl implements MemberController{

    private final MemberService memberService;

    @Override
    @PostMapping()
    public ResponseEntity<MemberVO> create(MemberCreateDto memberCreateDto) throws URISyntaxException {
        MemberVO memberVO = memberService.create(memberCreateDto);
        String createdMemberUri = "/member/" + memberVO.getId();
        URI uri = new URI(createdMemberUri);
        return ResponseEntity.created(uri).body(memberVO);
    }

    @Override
    @GetMapping("/{id}")
    public MemberVO findOne(Long id) {
        return null;
    }

    @Override
    public MemberVO update(Long id, MemberUpdateDto memberUpdateDto) {
        return null;
    }

    @Override
    public MemberVO remove(Long id, String accessToken) {
        return null;
    }
}
