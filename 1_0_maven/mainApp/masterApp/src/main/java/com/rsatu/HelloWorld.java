package com.rsatu;
import com.rsatu.HelloWorldMessage;

public class HelloWorld {
    public static void main(String[] args) {
        HelloWorldMessage hwm = new HelloWorldMessage();
        String message = hwm.getMessage();
        System.out.println(message);
    }
}
