package Jackson.JsonProperty;

import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJsonProperty {
    public static void main(String args[]) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"id\" : 1}";
        Student student = mapper.readerFor(Student.class).readValue(json);
        System.out.println(student.getTheId());
    }
}
class Student {
    private int id;
    Student(){}
    Student(int id){
        this.id = id;
    }
   @JsonProperty("id")
    public int getTheId() {
        return id;
    }
    @JsonProperty("id")
    public void setTheId(int id) {
        this.id = id;
    }
}