package com.talenco.tasksystem;

import com.talenco.tasksystem.dao.UserKeyRepository;
import com.talenco.tasksystem.domain.UserKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TasksystemApplicationTests {
    @Autowired
    private UserKeyRepository userKeyRepository;

    @Test
    public void contextLoads() {
        UserKey userKey = new UserKey();
        userKey.setUsername("admin");
        userKey.setPassword("123456");
        ArrayList<String> roles = new ArrayList<>();
        roles.add("ROLE_SUPERADMIN");
        userKey.setRoles(roles);
        userKeyRepository.save(userKey);
    }

}
