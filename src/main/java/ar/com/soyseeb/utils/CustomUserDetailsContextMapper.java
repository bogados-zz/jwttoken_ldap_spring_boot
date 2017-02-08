package ar.com.soyseeb.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by sbogado on 03/02/2017.
 */
public class CustomUserDetailsContextMapper extends LdapUserDetailsMapper {

    private List<String> admins;

    @Value("${techexam.config.admins}")
    public void setAdmins(String[] admins) {
        this.admins = Arrays.asList(admins);
    }

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {
        LdapUserDetails userDetails = (LdapUserDetails) super.mapUserFromContext(ctx, username, authorities);

        LdapUserDetailsImpl.Essence essence = new LdapUserDetailsImpl.Essence();
        essence.setDn(userDetails.getDn());
        essence.setUsername(userDetails.getUsername());
        essence.setPassword(userDetails.getPassword());
        if (admins.contains(userDetails.getUsername())) {
            essence.addAuthority(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        essence.addAuthority(new SimpleGrantedAuthority("ROLE_USER"));
        //Generate New UserDetails
        UserDetails res = essence.createUserDetails();
        res.getAuthorities().forEach(System.out::println);
        return res;
    }
}
