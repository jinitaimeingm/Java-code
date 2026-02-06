package com.task.platform.tcp.vo;

/**
 * UserVO：专门用于接口返回
 * 只包含“允许暴露”的字段
 */
public class UserVO {

    private Long id;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
