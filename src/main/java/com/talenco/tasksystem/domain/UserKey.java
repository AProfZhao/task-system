package com.talenco.tasksystem.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 用户登录信息
 *
 * @author echcz
 * @date 2019-04-16 22:30:27
 */
@Getter
@Setter
@Document(collection = "userKey")
public class UserKey {
    public static final int NORMAL = 0;
    public static final int DISABLE = 1;
    /**
     * id
     */
    @Id
    private String id;
    /**
     * 用户名
     */
    @Indexed(unique = true)
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 状态 0: 正常, 1: 禁用
     */
    @Indexed
    private int state;
    /**
     * 用户描述信息id
     */
    @Indexed(unique = true)
    private String userDescId;
    /**
     * 用户权限s
     */
    private List<String> roles;
}
