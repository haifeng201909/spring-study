package com.haifeng.study.proxy.staticproxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author haifeng
 * @date 2020-07-28 1:10
 *
 * 静态代理类
 * 实现日志扩展功能
 * 要求：
 * 1）和目标（类）实现同样的接口
 * 2）在静态代理类中传入目标对象实例，以便调用目标对象的方法
 * 3）可以在静态代理类的方法中添加代理逻辑代码
 */
@Component
public class LogProxy implements UserService{

    @Autowired
    private UserService userService;

    public void add() {
        System.out.println("调用方法add之前操作...");
        userService.add();
        System.out.println("调用方法add之后操作...");
    }

    public void delete() {
        System.out.println("调用方法delete之前操作...");
        userService.delete();
        System.out.println("调用方法delete之后操作...");
    }

    public void search() {
        System.out.println("调用方法search之前操作...");
        userService.search();
        System.out.println("调用方法search之后操作...");
    }

    public void update() {
        System.out.println("调用方法update之前操作...");
        userService.update();
        System.out.println("调用方法update之后操作...");
    }
}
