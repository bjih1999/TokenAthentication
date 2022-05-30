package me.jihyun.tokenlogin.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.jihyun.tokenlogin.authToken.AuthToken;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor
public class Member {

    public Member(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @OneToOne
    @JoinColumn(name = "auth_token_id")
    private AuthToken authToken;
}
