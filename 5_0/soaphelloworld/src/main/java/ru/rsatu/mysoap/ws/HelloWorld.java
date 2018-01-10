
package ru.rsatu.mysoap.ws;

import javax.jws.WebMethod;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL) //optional
public interface HelloWorld{

    @WebMethod String getHelloWorldAsString(String name);

}