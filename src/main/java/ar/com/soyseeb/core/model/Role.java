package ar.com.soyseeb.core.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by sbogado on 15/12/2016.
 */
public enum  Role implements GrantedAuthority {
    RRHH,
    ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
