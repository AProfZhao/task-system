package com.talenco.tasksystem.dao;

import com.mongodb.client.result.UpdateResult;
import com.talenco.tasksystem.domain.UserKey;
import com.talenco.tasksystem.util.MongoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * 用户处理信息数据访问类
 * 作为{@link UserKeyRepository}的补充
 *
 * @author echcz
 * @date 2019-04-22 16:40:09
 */
@Repository
public class UserKeyDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据userKey.id更新UserKey
     * @param userKey UserKey，userKey.id应有效
     */
    public UpdateResult updateUserKey(UserKey userKey) {
        Criteria criteria = Criteria.where(userKey.getId());
        Query query = new Query(criteria);
        Update update = MongoUtils.getUpdateIgnoreNull(userKey);
        return mongoTemplate.updateFirst(query, update, UserKey.class);
    }


}
