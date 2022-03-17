package Deserialize_new;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class LombokTest {
    ObjectMapper mapper;
    @Test
    public void test() throws JsonProcessingException {
        mapper = new ObjectMapper();
        StudentWithLombok student = new StudentWithLombok();
        student.setAge(15);
        student.setName("john");
        student.setHeight(175);
        student.setLastNAme("doe");
        student.setUniversity("harvard");
        String params = mapper.writeValueAsString(student);
        System.out.println(params);
    }
    @Test
    public void withRecord(){
        StudentRecord student1 = new StudentRecord("Irina","Inashvili", "Tbilisi");
        System.out.println(student1);
    }
    @Test
    public void studentRecordJson() throws JsonProcessingException {
        StudentRecord student2 = new StudentRecord("Alina",null, "Tbilisi");
        mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(student2));
    }
    @Test
    public void deserializationJackson() throws JsonProcessingException {
        StudentWithLombok st;
        String params = "{\"name\":\"john\",\"lastNAme\":\"doe\",\"height\":175.0,\"age\":15,\"university\":\"harvard\"}";
        mapper = new ObjectMapper();
        st = mapper.readValue(params,StudentWithLombok.class);
       // System.out.println(mapper.readValue(params,StudentWithLombok.class));
        System.out.println(st.getHeight());
    }
}
