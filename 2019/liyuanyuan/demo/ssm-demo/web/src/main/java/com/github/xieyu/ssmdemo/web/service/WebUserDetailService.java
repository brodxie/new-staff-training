package com.github.xieyu.ssmdemo.web.service;

import com.github.xieyu.ssmdemo.web.dao.UserDAO;
import com.github.xieyu.ssmdemo.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author xieyu
 */
@Service
public class WebUserDetailService implements UserDetailsService {
    @Autowired
    public UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户'" + username + "'不存在");
        }
        return user;
    }
}
