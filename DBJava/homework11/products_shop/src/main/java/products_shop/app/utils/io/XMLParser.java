package products_shop.app.utils.io;


import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 14:45.
 */

@Component
public class XMLParser {

    private JAXBContext jaxbContext;

    public XMLParser(){
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> clazz, String path) throws IOException, JAXBException {
        this.jaxbContext=JAXBContext.newInstance(clazz);
        T object = null;
        Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
        try (InputStream inputStream = clazz.getResourceAsStream(path)) {
            object = (T) unmarshaller.unmarshal(inputStream);
        }
        return object;
    }

    public <T> void writeObject(T clazz, String path) throws IOException, JAXBException {
        this.jaxbContext=JAXBContext.newInstance(clazz.getClass());
        Marshaller marshaller = this.jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        String fullPath = System.getProperty("user.dir") + path;
        try (OutputStream outputStream = new FileOutputStream(fullPath)) {
            marshaller.marshal(clazz, outputStream);
        }
    }
}
