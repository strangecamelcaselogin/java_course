package ru.rsatu.mysoap.client;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import ru.rsatu.mysoap.ws.HelloWorld;


public class HelloWorldClient {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9999/ws/hello?wsdl");
        QName qname = new QName("http://ws.mysoap.rsatu.ru/", "HelloWorldImplService");

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);

        System.out.println(hello.getHelloWorldAsString("wow, after few hours it works!"));

    }

}
