package com.exchange.usdpln.utilis;

import com.exchange.usdpln.models.Invoice;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class XmlService {

    StringWriter stringWriter = new StringWriter();

    public void saveToXml(Invoice invoice) throws JAXBException, IOException {
        JAXBContext context  = JAXBContext.newInstance(Invoice.class);
        Marshaller marshaller = context .createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(invoice, new File("./invoice.xml"));
    }

    public Invoice[] readFromFile() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Invoice.class);
        return (Invoice[]) context.createUnmarshaller()
            .unmarshal(new FileReader("./invoice.xml"));
    }

}
