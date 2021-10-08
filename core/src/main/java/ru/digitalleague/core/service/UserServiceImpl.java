package ru.digitalleague.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.digitalleague.core.api.UserService;
import ru.digitalleague.core.mapper.AuthorityMapper;
import ru.digitalleague.core.mapper.UserMapper;
import ru.digitalleague.core.model.Authority;
import ru.digitalleague.core.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registration(User user) {
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userMapper.insert(user);
        List<Authority> authorities = user.getAuthorities();
        authorities.forEach(authority -> authority.setUserId(user.getId()));
        authorityMapper.insertAll(authorities);
        return user;
    }

    @Override
    public User login(String login) {
        return userMapper.findTestSqlInjection(login);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userMapper.findByLogin(s)
                .orElseThrow(() -> new UsernameNotFoundException("No user found"));
    }
}
