package ru.rsatu.core;

import ru.rsatu.core.customAnnotations.Log;

public class Test implements TestInterface {
    @Log()
    public String getTestMessage() {
        return "testMessage";
    }

    public void printTextmessage() {
        System.out.println("textMessage Print");
    }
}
