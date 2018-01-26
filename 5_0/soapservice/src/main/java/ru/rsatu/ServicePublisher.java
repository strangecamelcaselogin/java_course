package ru.rsatu;

import javax.xml.ws.Endpoint;

public class ServicePublisher {
    public static void main(String[] args) {
        String url = "http://localhost:1212/studentsMarks";
        Endpoint.publish(url, new StudentMarks());
        System.out.println("Service started @ " + url);
    }
}
