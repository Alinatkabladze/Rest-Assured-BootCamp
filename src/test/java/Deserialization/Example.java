package Deserialization;

import Serialization.SimpleBean;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Example {

    @Test
public void whenJavaGotFromXmlStr_thenCorrect() throws IOException {
    XmlMapper xmlMapper = new XmlMapper();
    SimpleBean value
            = xmlMapper.readValue("<SimpleBean><x>"+1+"</x><y>2</y></SimpleBean>", SimpleBean.class);
        Assert.assertEquals(value.getX() , 1 );
}
    @Test
    public void whenJavaGotFromXmlFile_thenCorrect() throws IOException {
        File file = new File("simple_bean.xml");
        XmlMapper xmlMapper = new XmlMapper();
        SimpleBean value = xmlMapper.readValue(file, SimpleBean.class);
        assertTrue(value.getX() == 1 && value.getY() == 2);
    }

    private static final String XML = "<Person>...</Person>";

    @Test
    public void whenJavaSerializedToXmlFile_thenSuccess() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Adress adress = new Adress();
        adress.city="London";
        adress.streetName = "33";
        Person person = new Person();
        person.firstName = "John";
        person.lastName = "John";
        person.phoneNumbers.add("444555");
        person.address.add(adress);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlMapper.writeValue(byteArrayOutputStream, person);
        assertEquals(XML, byteArrayOutputStream.toString());
    }
}
