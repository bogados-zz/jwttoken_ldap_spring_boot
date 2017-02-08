package ar.com.soyseeb.core.dao;

import ar.com.soyseeb.core.model.security.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by stephan on 20.03.16.
 */
@Repository
public interface UserDao extends JpaRepository<UserBean, Long> {
    UserBean findByUsername(String username);
}
