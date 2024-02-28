package com.lmw.service.impl;

import com.lmw.entity.Account;
import com.lmw.mapper.UserMapper;
import com.lmw.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = userMapper.findUserByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("用户名或密码错误！");
        }
        return User.withUsername(account.getUsername())
                .password(encoder.encode(account.getPassword()))
                .roles(account.getRole())
                .build();
    }
}
