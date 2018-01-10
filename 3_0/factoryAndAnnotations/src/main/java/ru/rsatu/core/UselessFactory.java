package ru.rsatu.core;

public class UselessFactory {
    public TestInterface makeSimpleTest() throws ClassNotFoundException {
        return (TestInterface) UselessWrapper.wrap(new SimpleTest());
    }

    public TestInterface makeBetterTest() throws ClassNotFoundException {
        return (TestInterface) UselessWrapper.wrap(new BetterTest());
    }

}
