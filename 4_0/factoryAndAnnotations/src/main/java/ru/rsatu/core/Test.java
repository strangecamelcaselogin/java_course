package ru.rsatu.core;

@Log()
class Test implements TestInterface {
    public String getTestMessage() {
        return "testMessage";
    }
}