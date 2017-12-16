package ru.rsatu.core;

public class UselessFactory {
    public static TestInterface getTest(String testType) throws ClassNotFoundException{

        TestInterface test;
        if (testType.equals("better")) {
            test = new BetterTest();
        } else if (testType.equals("simple")) {
            test = new SimpleTest();
        } else {
            throw new IllegalArgumentException("testType argument must be 'simple' or 'better'");
        }

        // Создадим прокси объект, приведем его к интерфейсу и вернем
        // делаем это враппером согласно "принципу единственной ответственности"
        return (TestInterface) UselessWrapper.wrap(test);
    }

}
