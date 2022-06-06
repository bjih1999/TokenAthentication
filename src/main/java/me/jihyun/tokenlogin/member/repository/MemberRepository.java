package me.jihyun.tokenlogin.member.repository;

import me.jihyun.tokenlogin.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    Optional<Member> findByUserId(String userId);
}
