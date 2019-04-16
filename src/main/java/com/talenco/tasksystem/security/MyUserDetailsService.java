package com.talenco.tasksystem.security;

import com.talenco.tasksystem.dao.UserKeyRepository;
import com.talenco.tasksystem.domain.UserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 自定义UserDetailsService
 * 返回MyUserDetails
 *
 * @author echcz
 * @date 2019-04-16 23:53:35
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserKeyRepository userKeyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserKey> userKeyOptional = userKeyRepository.findFirstByUsername(username);
        UserKey userKey = userKeyOptional.orElseThrow(() -> new UsernameNotFoundException("用户不存在"));
        return new MyUserDetails(userKey);
    }
}
