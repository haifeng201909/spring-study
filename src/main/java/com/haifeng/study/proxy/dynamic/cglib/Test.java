package com.haifeng.study.proxy.dynamic.cglib;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author haifeng
 * @date 2020-07-30 1:50
 */
public class Test {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("proxy-dynamic-cglib-beans.xml");

        UserService userService = ac.getBean("userService", UserService.class);

        UserService proxy = (UserService) LogProxy.getProxy(userService);

        proxy.add();
        proxy.delete();
        proxy.update();
        proxy.search();

    }

}
