package ru.az.doverie.xml.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class MarshallerT<T> {

    public MarshallerT() {
    }

    public T unmarshal(Class<? extends T> clazz, File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        return (T) context.createUnmarshaller().unmarshal(file);
    }

    public void marshal(T t, File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(t.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(t, file);

    }

}
