package ru.rsatu.core;

import ru.rsatu.core.annotations.Log;

public class SimpleTest implements TestInterface {
    public static String message = "Simple message";

    @Log()
    public String getTestMessage() {
        return message;
    }

    public void printTextMessage() {
        System.out.println("Print: " + message);
    }
}
