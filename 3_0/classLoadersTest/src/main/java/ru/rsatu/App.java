package ru.rsatu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {

        String packageName = "ru.rsatu";
        String className = "Target";
        String methodName = "getMessage";

        CustomClassLoader customLoader = new CustomClassLoader();
        Class <?> loadedClass = customLoader.findClass(packageName + "." + className);

        Method m = loadedClass.getMethod(methodName);

        m.invoke(loadedClass.newInstance());
    }
}
