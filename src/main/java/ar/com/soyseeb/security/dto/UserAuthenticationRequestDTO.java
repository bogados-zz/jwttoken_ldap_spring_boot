package ar.com.soyseeb.security.dto;

import java.io.Serializable;

/**
 * @Autor: sbogado
 * email: seebogado@gmail.com
 *
 */
public class UserAuthenticationRequestDTO implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String username;
    private String password;

    public UserAuthenticationRequestDTO() {
        super();
    }

    public UserAuthenticationRequestDTO(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
