package br.com.danilooa.ocpjadee7.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.Date;

public class JavaToXml {

    public void marshal() throws JAXBException {
        Book book = new Book();
        book.setId(1L);
        book.setName("Book1");
        book.setAuthor("Author1");
        book.setDate(new Date());

        //throws JAXBException
        JAXBContext context = JAXBContext.newInstance(Book.class);
        //throws JAXBException
        Marshaller mar= context.createMarshaller();
        //throws PropertyException
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        //throws JAXBException
        mar.marshal(book, new File("C:\\development\\xmls\\book.xml"));
    }

}

