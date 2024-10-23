package com.esw.global.security.principal;

import com.esw.module.member.entities.Member;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


@Getter
@ToString
public class UserPrincipal implements UserDetails {

    private final Long id;
    private final String email;
    private final String role;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String email, String role, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.password = password;
        this.authorities = authorities;
    }

    private UserPrincipal(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.role = builder.role;
        this.password = builder.password;
        this.authorities = builder.authorities;
    }

    public static Builder builder(Long id, String email, String password, String role) {
        return new Builder(id, email, password, role);
    }


    public static class Builder {
        private final Long id;
        private final String email;
        private final String role;
        private final String password;
        private final Collection<? extends GrantedAuthority> authorities;

        public Builder(Long id, String email, String password, String role) {
            this.id = id;
            this.email = email;
            this.password = password;
            this.role = role;
            this.authorities = Collections.singletonList(new SimpleGrantedAuthority(role));
        }

        /**
         * 위 생성자에서 만약 입력 값 중 옵셔널 값일 경우 Setter를 통해 값을 초기화
         * 위 경우 Builder 클래스의 옵셔널 필드는 final 키워드 사용 불가
         * 이러한 경우 Builder 패턴을 사용하는 의미가 크게 낮아짐.
         */

        public UserPrincipal build() {
            return new UserPrincipal(this);
        }
    }

    public static UserPrincipal create(Member member) {
        return UserPrincipal.builder(member.getId(), member.getEmail(), member.getPassword(), member.getRole().getKey()).build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
