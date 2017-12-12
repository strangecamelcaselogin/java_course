package ru.rsatu;

import ru.rsatu.core.TestInterface;
import ru.rsatu.core.UselessFactory;

public class App {
    public static void main(String[] args) {
        TestInterface t = UselessFactory.getTest();
        String m = t.getTestMessage();
        System.out.println("Test say: " + m);
    }
}
