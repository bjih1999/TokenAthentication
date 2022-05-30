package me.jihyun.tokenlogin.member.repository;

import me.jihyun.tokenlogin.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
