package ru.digitalleague.core.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class Authority implements GrantedAuthority {
    private Long id;
    Long userId;
    private String authority;
    @Override
    public String getAuthority() {
        return authority;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }
}
