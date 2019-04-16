package com.talenco.tasksystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 结果实体
 *
 * 一般用于从后端返回前端
 *
 * @param <T> 内容类型
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    /**
     * 结果状态码，其取值应属于 ResultCode
     */
    private String code;
    /**
     * 内容
     */
    private T content;
}
