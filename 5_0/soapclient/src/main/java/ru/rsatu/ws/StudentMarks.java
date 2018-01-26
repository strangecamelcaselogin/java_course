
package ru.rsatu.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StudentMarks", targetNamespace = "http://rsatu.ru/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StudentMarks {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns ru.rsatu.ws.Subjects
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://rsatu.ru/StudentMarks/getMarksByGroupAndNameRequest", output = "http://rsatu.ru/StudentMarks/getMarksByGroupAndNameResponse")
    public Subjects getMarksByGroupAndName(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

}
