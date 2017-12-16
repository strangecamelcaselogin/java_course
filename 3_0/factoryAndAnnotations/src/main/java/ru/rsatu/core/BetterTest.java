package ru.rsatu.core;

import ru.rsatu.core.annotations.Log;

public class BetterTest implements TestInterface {
    public static String message = "Better message";

    public String getTestMessage() {
        return message;
    }

    @Log
    public void printTextMessage() {
        System.out.println("Print: " + message);
    }
}
