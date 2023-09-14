package com.squadcaller.backend.security;

import com.squadcaller.backend.entity.User;
import com.squadcaller.backend.model.user.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class UserPrincipal implements OAuth2User, UserDetails {
    private Long id;
    private String email;
    private String password;
    private UserRole role;
    private Map<String, Object> attributes;

    public UserPrincipal(Long id, String email, String password, UserRole role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public static UserPrincipal create(User user) {
        return new UserPrincipal(
                user.getUserId(),
                user.getEmail(),
                user.getPassword(),
                UserRole.USER
        );
    }


}
