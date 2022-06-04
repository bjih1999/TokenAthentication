package me.jihyun.tokenlogin.authToken.controller;

import me.jihyun.tokenlogin.authToken.dto.LoginDto;
import me.jihyun.tokenlogin.authToken.dto.LogoutDto;
import me.jihyun.tokenlogin.member.vo.MemberVO;
import org.springframework.http.ResponseEntity;

public interface AuthController {

    ResponseEntity<MemberVO> login(LoginDto loginDto);

    ResponseEntity<MemberVO> logout(LogoutDto logoutDto);
}
