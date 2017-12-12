package ru.rsatu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException, ClassNotFoundException {

        String className = "ru.rsatu.Target";
        String methodName = "getMessage";

        CustomClassLoader customLoader = new CustomClassLoader();
        Class <?> loadedClass = customLoader.loadClass(className, false);

        Method m = loadedClass.getMethod(methodName);

        m.invoke(loadedClass.newInstance());
    }
}
