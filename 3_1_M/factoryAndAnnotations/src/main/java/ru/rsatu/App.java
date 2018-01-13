package ru.rsatu;

import ru.rsatu.core.TestInterface;
import ru.rsatu.core.MyFactory;

public class App {
    public static void main(String[] args) throws Exception {

        // получим "простой экземпляр"
        MyFactory testFactory = new MyFactory();

        TestInterface simpleT = testFactory.makeSimpleTest();

        System.out.println("SimpleTest say WITH log: '" + simpleT.getTestMessage() + "'\n");

        System.out.println("SimpleTest will print WITHOUT log:");
        simpleT.printTextMessage();

        System.out.println("\n\n\n");

        // получим "лучший" экземпляр
        TestInterface betterT = testFactory.makeBetterTest();

        System.out.println("BetterTest say and WITHOUT log: '" + betterT.getTestMessage() + "'\n");

        System.out.println("BetterTest will print WITH log:");
        betterT.printTextMessage();
    }
}
