package ar.com.soyseeb.core.services;

import ar.com.soyseeb.core.dao.UserDao;
import ar.com.soyseeb.core.model.security.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by stephan on 20.03.16.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBean userBean = userDao.findByUsername(username);

        if (userBean == null) {
            throw new UsernameNotFoundException(String.format("No se ha encontrado el usuario con '%s'.", username));
        } else {
            return userBean;
        }
    }

    public UserBean saveUser(UserBean userBean){
       return userDao.save(userBean);
    }

    public void deleteUser(UserBean userBean){
        userDao.delete(userBean);
    }

    public void deleteUser(Long id){
        userDao.delete(id);
    }

}
