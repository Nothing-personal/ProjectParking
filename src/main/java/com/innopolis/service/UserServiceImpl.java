package com.innopolis.service;

import com.innopolis.entity.Users;
import com.innopolis.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Kevin Khanda on 21.09.2016.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    public boolean addUser(String email, String phone, String password) {
        try {
            userRepository.addUser(new Users(email, phone, password));
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
