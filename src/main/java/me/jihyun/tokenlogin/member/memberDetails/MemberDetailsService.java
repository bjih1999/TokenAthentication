package me.jihyun.tokenlogin.member.memberDetails;

import lombok.RequiredArgsConstructor;
import me.jihyun.tokenlogin.member.Member;
import me.jihyun.tokenlogin.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public MemberDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> memberOptional = memberRepository.findByUserId(username);

        Member member = memberOptional.orElseThrow(() -> new UsernameNotFoundException("해당 유저를 찾을 수 없습니다."));

        return new MemberDetails(member.getUserId(), member.getPassword(), member.getUsername(), member.getRole());
    }
}
