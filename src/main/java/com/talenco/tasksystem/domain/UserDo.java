package com.talenco.tasksystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 用户领域模型
 *
 * @author echcz
 * @date 2019-04-16 22:40:59
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDo {
    /**
     * 用户描述信息
     */
    private UserDesc user;
    /**
     * 用户权限s
     */
    private List<String> roles;
}
