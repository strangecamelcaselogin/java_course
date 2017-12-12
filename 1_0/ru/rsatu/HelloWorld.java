package ru.rsatu;
import ru.rsatu.supplier.HelloWorldSupplier;


public class HelloWorld {
    public static void main(String[] args) {
        String message = new HelloWorldSupplier().getMessage();
        System.out.println(message);
    }
}
