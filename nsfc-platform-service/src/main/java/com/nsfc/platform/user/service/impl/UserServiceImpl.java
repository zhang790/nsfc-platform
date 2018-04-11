package com.nsfc.platform.user.service.impl;

import com.nsfc.platform.user.dao.User;
import com.nsfc.platform.user.dao.UserRepository;
import com.nsfc.platform.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

//    @Autowired
//    UserRepository userRepository;

    public List<User> list() {
        return null;
    }
}