package com.haifeng.study.proxy.dynamic.jdk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author haifeng
 * @date 2020-07-29 1:43
 */
public class Test {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("proxy-dynamic-jdk-beans.xml");

        UserService userService = ac.getBean("userServiceImpl", UserServiceImpl.class);

        UserService proxy = (UserService) LogProxy.getProxy(userService);

        proxy.add();
        proxy.delete();
        proxy.update();
        proxy.search();

    }

}
