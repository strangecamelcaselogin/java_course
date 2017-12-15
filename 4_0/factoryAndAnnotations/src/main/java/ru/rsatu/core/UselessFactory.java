package ru.rsatu.core;

import java.lang.reflect.Proxy;

public class UselessFactory {
    public static TestInterface getTest() throws ClassNotFoundException{

        // Создадим прокси объект и вернем его
        return (TestInterface) Proxy.newProxyInstance(
                Test.class.getClassLoader(),
                Test.class.getInterfaces(),
                new LogInvocation(new Test(), Log.class));
    }

}
