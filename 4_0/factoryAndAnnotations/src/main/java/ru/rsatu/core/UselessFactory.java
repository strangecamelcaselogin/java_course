package ru.rsatu.core;

public class UselessFactory {
    public static TestInterface getTest() {

        // todo more implements on TestInterface
        // todo use Log annotation
        return new Test();
    }

}
