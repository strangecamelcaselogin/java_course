package ru.rsatu.core;

// import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UselessFactory {
    public static TestInterface getTest() throws ClassNotFoundException{
        Test test = new Test();

//        boolean isNeedToProxy = true;
//        for (Method m: test.getClass().getMethods()) {
//            if (m.isAnnotationPresent(Log.class)) {
//                isNeedToProxy = true;
//                break;
//            }
//        }

        // Создадим прокси объект и вернем его
        return (TestInterface) Proxy.newProxyInstance(
                test.getClass().getClassLoader(),
                test.getClass().getInterfaces(),
                new UselessInvocationHandler(test));
    }

}
