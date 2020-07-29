package com.haifeng.study.proxy.dynamic.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 生成cglib代理对象
 *
 * @author haifeng
 * @date 2020-07-30 1:26
 */
public class LogProxy {

    /**
     * 生成cglib代理对象
     * @param target 目标对象（目标对象没有接口）
     * @return 生成的Cglib子类代理对象
     */
    public static Object getProxy(final Object target){

        /**
         * 参数一：目标对象的类型(target.getClass()) (其实目标对象的类型就是Cglib代理对象的父类)
         * 参数二：MethodInterceptor接口，用于编写代理对象的代理逻辑代码 通常提供MethodInterceptor接口的匿名内部即可
         */
        return Enhancer.create(
                target.getClass(),
                new MethodInterceptor() {
                    /**
                     * intercept方法：在调用代理对象的每个方法的时候会执行
                     * @param proxy 生成的代理对象
                     * @param method 目标对象的方法对象
                     * @param args 目标对象的方法参数列表
                     * @param methodProxy 代理对象的方法对象
                     * @return
                     * @throws Throwable
                     */
                    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                        // 目标对象方法名称
                        String methodName = method.getName();

                        System.out.println("调用目标方法" + methodName + "前的操作");

                        // 调用目标对象的方法
                        // 方式一：直接使用目标对象调用目标对象的方法
                        Object result = method.invoke(target, args);
                        // 方式二：使用代理类（子类）调用 目标对象（父类）的方法
                        // invokeSuper: 调用父类的方法
                        // Object result = methodProxy.invokeSuper(proxy, args);

                        System.out.println("调用目标方法" + methodName + "后的操作");
                        return result;
                    }
                }
        );

    }

}
