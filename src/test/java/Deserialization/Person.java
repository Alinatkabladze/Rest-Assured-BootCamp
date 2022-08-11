package Deserialization;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public String firstName;
    public String lastName;
    public List<String> phoneNumbers = new ArrayList<>();
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<Adress> address = new ArrayList<>();

    //standard setters and getters
}
