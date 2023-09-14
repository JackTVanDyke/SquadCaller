package com.squadcaller.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.squadcaller.backend.model.user.UserAuthProvider;
import com.squadcaller.backend.model.user.UserRole;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.security.AuthProvider;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @NaturalId
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Email
    private String username;

    private String imageUrl;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;

    @Column
    Set<String> friends = new HashSet<>();

    public User() {
    }

    public User(Long userId, String name, String email, String username, String imageUrl, String password, UserRole role, Set<String> friends) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.imageUrl = imageUrl;
        this.password = password;
        this.role = role;
        this.friends = friends;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Set<String> getFriends() {
        return friends;
    }

    public void setFriends(Set<String> friends) {
        this.friends = friends;
    }

    public AuthProvider getProvider() {
        return provider;
    }

    public void setProvider(UserAuthProvider provider) {
        this.provider = provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userId.equals(user.userId)) return false;
        if (!name.equals(user.name)) return false;
        if (!email.equals(user.email)) return false;
        if (!username.equals(user.username)) return false;
        if (imageUrl != null ? !imageUrl.equals(user.imageUrl) : user.imageUrl != null) return false;
        if (!password.equals(user.password)) return false;
        if (role != user.role) return false;
        if (provider != null ? !provider.equals(user.provider) : user.provider != null) return false;
        if (providerId != null ? !providerId.equals(user.providerId) : user.providerId != null) return false;
        return friends != null ? friends.equals(user.friends) : user.friends == null;
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + password.hashCode();
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (providerId != null ? providerId.hashCode() : 0);
        result = 31 * result + (friends != null ? friends.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", provider=" + provider +
                ", providerId='" + providerId + '\'' +
                ", friends=" + friends +
                '}';
    }
}
