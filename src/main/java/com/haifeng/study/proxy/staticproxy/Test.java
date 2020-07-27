package com.haifeng.study.proxy.staticproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author haifeng
 * @date 2020-07-28 1:27
 */
public class Test {

    public static void main(String[] args){

        ApplicationContext ac = new ClassPathXmlApplicationContext("proxy-static-beans.xml");

        LogProxy proxy = ac.getBean("logProxy", LogProxy.class);

        proxy.add();
        proxy.delete();
        proxy.search();
        proxy.update();

    }

}
