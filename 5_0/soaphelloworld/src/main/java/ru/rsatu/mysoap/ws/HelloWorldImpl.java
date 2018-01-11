package ru.rsatu.mysoap.ws;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "ru.rsatu.mysoap.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld{
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS, say something: " + name;
    }

}