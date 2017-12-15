package ru.rsatu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException, ClassNotFoundException {

        String className = "ru.rsatu.Target";
        String anotherClassName = "ru.rsatu.AnotherTarget";
        String methodName = "getMessage";

        // первый класслоадер
        CustomClassLoader customLoader1 = new CustomClassLoader();
        Class <?> loadedClass = customLoader1.loadClass(className, false);

        Method m = loadedClass.getMethod(methodName);
        Object result = m.invoke(loadedClass.newInstance());
        System.out.println((String) result);

        // второй
        CustomClassLoader customLoader2 = new CustomClassLoader();
        Class <?> anotherLoadedClass = customLoader2.loadClass(className, false);

        Method m2 = anotherLoadedClass.getMethod(methodName);
        Object result2 = m2.invoke(anotherLoadedClass.newInstance());
        System.out.println((String) result2);

        // загруженный AnotherTarget
        Class <?> extendedLoadedClass = customLoader1.loadClass(anotherClassName, false);

        Method m3 = extendedLoadedClass.getMethod(methodName);
        Object result3 = m3.invoke(extendedLoadedClass.newInstance());
        System.out.println((String) result3);
    }
}
