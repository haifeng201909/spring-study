package com.haifeng.study.proxy.dynamic.jdk;

import org.springframework.stereotype.Component;

/**
 * @author haifeng
 * @date 2020-07-28 1:07
 */
@Component
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("添加用户逻辑");
    }

    public void delete() {
        System.out.println("删除用户逻辑");
    }

    public void search() {
        System.out.println("查找用户逻辑");
    }

    public void update() {
        System.out.println("更新用户逻辑");
    }
}
