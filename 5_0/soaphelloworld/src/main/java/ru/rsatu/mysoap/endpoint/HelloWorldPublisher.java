package ru.rsatu.mysoap.endpoint;

import javax.xml.ws.Endpoint;
import ru.rsatu.mysoap.ws.HelloWorldImpl;

public class HelloWorldPublisher{

    public static void main(String[] args) {
        Endpoint.publish("http://0.0.0.0:9999/ws/hello", new HelloWorldImpl());
    }

}
