package ru.rsatu.core;

import java.lang.reflect.Proxy;

/**
 * Врапит объекты типа TestInterface с MyInvocationHandler
 */
public class MyWrapper {
    public static Object wrap(TestInterface obj) {
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new MyInvocationHandler(obj));
    }
}
