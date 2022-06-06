package me.jihyun.tokenlogin.member.service;

import lombok.RequiredArgsConstructor;
import me.jihyun.tokenlogin.member.Member;
import me.jihyun.tokenlogin.member.dto.MemberCreateDto;
import me.jihyun.tokenlogin.member.dto.MemberUpdateDto;
import me.jihyun.tokenlogin.member.repository.MemberRepository;
import me.jihyun.tokenlogin.member.vo.MemberVO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Override
    public MemberVO create(MemberCreateDto memberCreateDto) {
        Member member = new Member(memberCreateDto.getUserId(),
                memberCreateDto.getPassword(),
                memberCreateDto.getUsername(),
                memberCreateDto.getRole()
        );
        member = memberRepository.save(member);
        return new MemberVO(member);
    }

    @Override
    public MemberVO findOne(String id) {
        return null;
    }

    @Override
    public MemberVO update(String id, MemberUpdateDto memberUpdateDto) {
        return null;
    }

    @Override
    public MemberVO remove(String id, String accessToken) {
        return null;
    }
}
