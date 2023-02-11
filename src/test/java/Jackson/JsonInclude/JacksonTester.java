package Jackson.JsonInclude;

import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester {
    public static void main(String args[]){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student student = new Student(1,"");
            String jsonString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(student);
            System.out.println(jsonString);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
@JsonInclude(JsonInclude.Include.NON_EMPTY)
class Student {
    public int id;
    public String name;

    Student(int id,String name){
        this.id = id;
        this.name = name;
    }
}