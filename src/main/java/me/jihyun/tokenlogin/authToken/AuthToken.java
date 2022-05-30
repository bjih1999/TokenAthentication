package me.jihyun.tokenlogin.authToken;

import lombok.Getter;
import me.jihyun.tokenlogin.member.Member;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "auth_token")
public class AuthToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "authToken")
    private Member member;

    @Column(name = "refresh_token")
    private String RefreshToken;
}
