package lesson16.xml_serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Arrays;

public class JaXBExample {
    public static void main(String[] args) throws JAXBException {


        Customer customer = new Customer();
        customer.setId(100);
        customer.setName("test");
        customer.setAge(29);
        customer.setOrders(Arrays.asList("test1", "test2", "test3"));


        File file = new File("customer.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = jaxbContext.createMarshaller();


        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(customer, file);


    }

}
