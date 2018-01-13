package ru.rsatu.core;

public class MyFactory {
    public TestInterface makeSimpleTest() throws ClassNotFoundException {
        return (TestInterface) MyWrapper.wrap(new SimpleTest());
    }

    public TestInterface makeBetterTest() throws ClassNotFoundException {
        return (TestInterface) MyWrapper.wrap(new BetterTest());
    }

}
