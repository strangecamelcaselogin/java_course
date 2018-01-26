
package ru.rsatu.ws;

import ru.rsatu.ws.Subject;
import ru.rsatu.ws.Subjects;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.rsatu package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Subjects_QNAME = new QName("http://rsatu.ru/", "subjects");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.rsatu
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Subject }
     * 
     */
    public Subject createSubject() {
        return new Subject();
    }

    /**
     * Create an instance of {@link Subjects }
     * 
     */
    public Subjects createSubjects() {
        return new Subjects();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Subjects }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rsatu.ru/", name = "subjects")
    public JAXBElement<Subjects> createSubjects(Subjects value) {
        return new JAXBElement<Subjects>(_Subjects_QNAME, Subjects.class, null, value);
    }

}
