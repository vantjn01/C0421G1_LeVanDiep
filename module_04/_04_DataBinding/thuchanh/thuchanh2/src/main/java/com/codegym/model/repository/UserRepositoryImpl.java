package com.codegym.model.repository;

import com.codegym.model.bean.Login;
import com.codegym.model.bean.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private static List<User> users;
    static {
        users= new ArrayList<>();
        User u1 = new User();
        u1.setAccount("john");
        u1.setAge(10);
        u1.setEmail("john@gmail");
        u1.setName("John");
        u1.setPassword("123");
        users.add(u1);

        users= new ArrayList<>();
        User u2 = new User();
        u2.setAccount("an");
        u2.setAge(100);
        u2.setEmail("an@gmail");
        u2.setName("An");
        u2.setPassword("123");
        users.add(u2);

        users= new ArrayList<>();
        User u3 = new User();
        u3.setAccount("cena");
        u3.setAge(12);
        u3.setEmail("cena@gmail");
        u3.setName("cena");
        u3.setPassword("123");
        users.add(u3);
    }

    @Override
    public User checkLogin(Login login) {
        for (User u : users) {
            if (u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())) {
                return u;
            }

        }
        return null;
    }
}
