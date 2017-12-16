package ru.rsatu.core;

import java.lang.reflect.Proxy;

/**
 * Врапит объекты типа TestInterface с UselessInvocationHandler
 */
public class UselessWrapper {
    public static Object wrap(TestInterface obj) {
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new UselessInvocationHandler(obj));
    }
}
