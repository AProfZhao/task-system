package com.talenco.tasksystem.service.impl;

import com.mongodb.client.result.UpdateResult;
import com.talenco.tasksystem.dao.UserDescDao;
import com.talenco.tasksystem.dao.UserDescRepository;
import com.talenco.tasksystem.dao.UserKeyDao;
import com.talenco.tasksystem.dao.UserKeyRepository;
import com.talenco.tasksystem.domain.UserDesc;
import com.talenco.tasksystem.domain.UserKey;
import com.talenco.tasksystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 用户服务类
 *
 * @author echcz
 * @date 2019-04-16 23:44:33
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserKeyRepository userKeyRepository;
    @Autowired
    private UserKeyDao userKeyDao;
    @Autowired
    private UserDescRepository userDescRepository;
    @Autowired
    private UserDescDao userDescDao;

    @Override
    public Optional<UserKey> getUserKeyById(String id) {
        return userKeyRepository.findById(id);
    }

    @Override
    public Optional<UserKey> getUserKeyByUsername(String username) {
        return userKeyRepository.findFirstByUsername(username);
    }

    @Override
    public List<UserKey> getAllUserKey() {
        return userKeyRepository.findAll();
    }

    @Override
    public List<UserKey> getAllUserKeyButAdmin() {
        return userKeyRepository.findAllByUsernameNot(UserKey.NAME_ADMIN);
    }

    @Override
    public boolean addUserKey(UserKey userKey) {
        try {
            userKey.setId(null);
            userKeyRepository.save(userKey);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.warn(e.toString());
            return false;
        }
    }

    @Override
    public boolean setUserKey(UserKey userKey) {
        try {
            UpdateResult updateResult = userKeyDao.updateUserKey(userKey);
            if (updateResult.isModifiedCountAvailable()) {
                return updateResult.getModifiedCount() > 0;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.warn(e.toString());
            return false;
        }
    }

    @Override
    public boolean removeUserKeyById(String id) {
        try {
            userKeyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.warn(e.toString());
            return false;
        }
    }

    @Override
    public Optional<UserDesc> getUserDescById(String id) {
        return userDescRepository.findById(id);
    }

    @Override
    public boolean setUserDesc(UserDesc userDesc) {
        try {
            UpdateResult updateResult = userDescDao.updateUserDesc(userDesc);
            if (updateResult.isModifiedCountAvailable()) {
                return updateResult.getModifiedCount() > 0;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.warn(e.toString());
            return false;
        }
    }

    @Override
    public boolean removeUserDescById(String id) {
        try {
            userDescRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.warn(e.toString());
            return false;
        }
    }
}
