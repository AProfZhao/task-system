package com.talenco.tasksystem.entity;

/**
 * 结果实体
 *
 * 一般用于从后端返回前端
 *
 * @param <T> 内容类型
 */
public class Result<T> {
    /**
     * 结果状态码，其取值应属于 ResultCode
     */
    private String code;
    /**
     * 内容
     */
    private T content;

    public Result() {
    }

    public Result(String code, T content) {
        this.code = code;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
