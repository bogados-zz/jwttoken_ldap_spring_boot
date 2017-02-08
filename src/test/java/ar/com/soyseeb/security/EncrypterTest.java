package ar.com.soyseeb.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by sbogado on 19/12/2016.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EncrypterTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void encodeWord(){
        System.out.println(passwordEncoder.encode("admin"));
    }


}
