package com.talenco.tasksystem.domain;

import java.util.List;

public class UserVo {
    private UserDesc user;
    private List<String> roles;

    public UserVo() {
    }

    public UserVo(UserDesc user, List<String> roles) {
        this.user = user;
        this.roles = roles;
    }

    public UserDesc getUser() {
        return user;
    }

    public void setUser(UserDesc user) {
        this.user = user;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
