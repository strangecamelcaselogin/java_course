package ru.rsatu;

import ru.rsatu.University;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


public class main {

    public static void main (String[] args)  {
        University departmentType = new University();
        departmentType.setUniversityName("100");

        try {

            File file = new File("./file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(University.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(departmentType, file);
            jaxbMarshaller.marshal(departmentType, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
