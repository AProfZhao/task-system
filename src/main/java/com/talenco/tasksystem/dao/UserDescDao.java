package com.talenco.tasksystem.dao;

import com.mongodb.client.result.UpdateResult;
import com.talenco.tasksystem.domain.UserDesc;
import com.talenco.tasksystem.domain.UserKey;
import com.talenco.tasksystem.util.MongoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class UserDescDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据userDesc.id更新UserDesc
     * @param userDesc UserDesc，userDesc.id应有效
     */
    public UpdateResult updateUserDesc(UserDesc userDesc) {
        Criteria criteria = Criteria.where(userDesc.getId());
        Query query = new Query(criteria);
        Update update = MongoUtils.getUpdateIgnoreNull(userDesc);
        return mongoTemplate.updateFirst(query, update, UserDesc.class);
    }
}
