package com.haifeng.study.proxy.dynamic.jdk;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author haifeng
 * @date 2020-07-29 1:43
 */
@Component
public class LogProxy {

    /**
     * 生成JDK动态代理对象
     *
     * @param target 目标对象
     * @return JDK动态代理对象
     */
    public static Object getProxy(final Object target){

        /**
         * 参数一：类加载器，JDK动态代理的底层使用类加载器来生成的一个动态类的。通常传入当前类的类加载器即可
         * 参数二：目标对象的接口列表（所有接口），通常使用目标对象获取接口列表（target.getClass().getInterfaces()）
         * 参数三：接口 编写代理类的代理逻辑代码 通常要提供InvocationHandler接口的实现类（匿名内部类的方式提供）
         */
        return Proxy.newProxyInstance(
                LogProxy.class.getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * invoke 编写代理类的代理逻辑
                     * @param proxy JDK动态代理对象
                     * @param method 目标对象的执行方法的对象
                     * @param args 目标对象的方法参数列表
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String methodName = method.getName();
                        System.out.println("方法" + methodName + "执行前逻辑");

                        /**
                         * 调用目标对象的方法
                         * 参数一：执行的对象（必须传入目标对象，不能传入代理对象，否则会死循环）
                         * 参数二：方法的参数列表
                         */
                        Object result = method.invoke(target, args);

                        System.out.println("方法" + methodName + "执行后逻辑");
                        return result;
                    }
                }
        );

    }

}
