package com.talenco.tasksystem.util;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Map;

public class MongoUtils {
    private static final String EXCLUDE_KEY = "class";
    private MongoUtils(){}

    /**
     * 根据bean获取对应的忽略了空值的update
     * @param bean bean
     * @return update
     */
    public static Update getUpdateIgnoreNull(Object bean) {
        Update update = new Update();
        BeanMap beanMap = new BeanMap(bean);
        for (Map.Entry<Object, Object> entry : beanMap.entrySet()) {
            Object value = entry.getValue();
            String key = (String)entry.getKey();
            if (value != null && !StringUtils.equals(EXCLUDE_KEY, key)) {
                update.set(key, value);
            }
        }
        return update;
    }
}
