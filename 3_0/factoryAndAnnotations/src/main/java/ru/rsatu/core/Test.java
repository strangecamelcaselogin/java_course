package ru.rsatu.core;

public class Test implements TestInterface {
    @Log()
    public String getTestMessage() {
        return "testMessage";
    }

    public void printTextmessage() {
        System.out.println("textMessage Print");
    }
}