package ru.digitalleague.core.model;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class User implements UserDetails {
    private Long id;

    private String username;

    private String password;

    private List<Authority> authorities;

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authority> getAuthorities() {
        return this.authorities;
    }

    public Long getId() {
        return this.id;
    }
}
