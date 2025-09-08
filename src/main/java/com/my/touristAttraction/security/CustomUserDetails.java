package com.my.touristAttraction.security;

import com.my.touristAttraction.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {
    private final com.my.touristAttraction.entity.User user;
    public CustomUserDetails(User user) { this.user = user; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // 권한을 정의해야 할 경우, 여기에 추가
    }

    @Override
    public String getPassword() {
        return null; // 비밀번호는 JWT에서 확인하므로 null로 두거나 구현
    }

    @Override
    public String getUsername() {
        return this.username;
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








//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return user.getRoles().stream()
//                .map(role -> (GrantedAuthority) () -> role) // role.getName()을 사용
//                .collect(Collectors.toSet());
//    }



//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of();
//    }
//
//    @Override
//    public String getPassword() { return user.getPassword(); }
//
//    @Override
//    public String getUsername() { return user.getUsername(); }
//
//    @Override
//    public boolean isAccountNonExpired() { return true; }
//
//    @Override
//    public boolean isAccountNonLocked() { return user.isEnabled(); }
//
//    @Override
//    public boolean isCredentialsNonExpired() { return true; }
//
//    @Override
//    public boolean isEnabled() { return user.isEnabled(); }
}
