package com.talenco.tasksystem.service;

import com.talenco.tasksystem.dao.UserKeyDao;
import com.talenco.tasksystem.domain.UserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserKeyService implements UserDetailsService {
    @Autowired
    private UserKeyDao userKeyDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserKey> userKeyOptional = userKeyDao.findFirstByUsername(s);
        if (userKeyOptional.isPresent()) {
            return userKeyOptional.get();
        } else {
            throw new UsernameNotFoundException("用户不存在");
        }
    }
}
