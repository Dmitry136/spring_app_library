package com.erygindmitri.springlibrary.spring_app_library.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
