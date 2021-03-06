package ru.rsatu;

import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException, ClassNotFoundException {

        String className = "ru.rsatu.Target";
        String anotherClassName = "ru.rsatu.AnotherTarget";

        TargetInterface x, y, z;
        // первый класслоадер
        MyClassLoader Loader1 = new MyClassLoader();
        x = (TargetInterface) Loader1.loadClass(className).newInstance();
        System.out.println(x.getMessage());
        System.out.println(String.format("Class name: %s, ClassLoader: %s\n", x.getClass(), x.getClass().getClassLoader()));

        // второй
        MyClassLoader Loader2 = new MyClassLoader();
        y = (TargetInterface) Loader2.loadClass(className).newInstance();
        System.out.println(y.getMessage());
        System.out.println(String.format("Class name: %s, ClassLoader: %s\n", y.getClass(), y.getClass().getClassLoader()));

        // загруженный AnotherTarget
        z = (TargetInterface) Loader1.loadClass(anotherClassName).newInstance();
        System.out.println(z.getMessage());
        System.out.println(String.format("Class name: %s, ClassLoader: %s", z.getClass(), z.getClass().getClassLoader()));
    }
}
