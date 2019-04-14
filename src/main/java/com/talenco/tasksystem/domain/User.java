package com.talenco.tasksystem.domain;

public class User {
    private UserKey key;
    private UserDesc desc;

    public User() {
    }

    public User(UserKey key, UserDesc desc) {
        this.key = key;
        this.desc = desc;
    }

    public UserKey getKey() {
        return key;
    }

    public void setKey(UserKey key) {
        this.key = key;
    }

    public UserDesc getDesc() {
        return desc;
    }

    public void setDesc(UserDesc desc) {
        this.desc = desc;
    }
}
