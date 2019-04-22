package com.talenco.tasksystem;

import com.talenco.tasksystem.dao.ProjectRepository;
import com.talenco.tasksystem.dao.UserKeyRepository;
import com.talenco.tasksystem.domain.Module;
import com.talenco.tasksystem.domain.Project;
import com.talenco.tasksystem.domain.UserDesc;
import com.talenco.tasksystem.domain.UserKey;
import org.apache.commons.beanutils.BeanMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TasksystemApplicationTests {
    @Autowired
    private UserKeyRepository userKeyRepository;
    @Autowired
    private ProjectRepository projectRepository;

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

    @Test
    public void projectRepositoryTest() {
        Module test = new Module();
        test.setDesc("测试模块");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("admin");
        test.setPrincipals(strings);
        test.setCreator("admin");
        test.setCreateTm(System.currentTimeMillis());
        Module dev = new Module();
        dev.setDesc("开发模块");
        dev.setPrincipals(strings);
        dev.setCreator("user");
        dev.setCreateTm(System.currentTimeMillis());
        Project project = new Project();
        project.setDesc("我的项目2");
        project.setName("我的项目2");
        HashMap<String, Module> modules = new HashMap<>();
        modules.put("测试模块 test", test);
        modules.put("开发模块 dev", dev);
        project.setModules(modules);
        project.setPrincipals(strings);
        project.setCreator("admin");
        project.setCreateTm(System.currentTimeMillis());
        projectRepository.save(project);
    }

    @Test
    public void beanMapTest() {
        UserDesc userDesc = new UserDesc();
        userDesc.setDesc("it is userDesc");
        userDesc.setName("userDesc");
        ArrayList<String> labels = new ArrayList<>();
        labels.add("user");
        userDesc.setLabels(labels);
        BeanMap beanMap = new BeanMap(userDesc);
        for (Map.Entry<Object, Object> entry : beanMap.entrySet()) {
            Object key = entry.getKey();
            Class keyClass = null;
            if (key != null) {
                keyClass = key.getClass();
            }
            Object value = entry.getValue();
            Class valueClass = null;
            if (value != null) {
                valueClass = value.getClass();
            }
            System.out.println(keyClass + ": " + key + "==>" + valueClass + ": " + value);
        }
    }

}
