package ar.com.soyseeb.core.model.security;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "AUTHORITY")
public class Authority implements GrantedAuthority{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private List<UserBean> userBeen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }

    public List<UserBean> getUserBeen() {
        return userBeen;
    }

    public void setUserBeen(List<UserBean> userBeen) {
        this.userBeen = userBeen;
    }

    @Override
    public String getAuthority() {
        return name.name();
    }
}