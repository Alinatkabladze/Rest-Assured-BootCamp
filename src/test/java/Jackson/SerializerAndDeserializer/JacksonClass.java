package Jackson.SerializerAndDeserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class JacksonClass {
    UserWithJackson user;
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testing() throws JsonProcessingException {
        user = new UserWithJackson();
        user.setName("Test");
        user.setEmail("Test");
        user.setAge(22);
        user.setBirthDate(LocalDateTime.of(1999,10,21,10,15));
        user.setRegistrationDate(LocalDateTime.now());
        System.out.println(mapper.writeValueAsString(user));
    }
    @Test()
    public void deserialize() throws JsonProcessingException {
        String jsonData = "{\"name\":\"Test\",\"email\":\"Test\",\"age\":22,\"registrationDate\":\"2022-08-06T10:41:17.433266500\",\"birthDate\":\"1999-10-21T10:15\"}\n";
        user = mapper.readValue(jsonData,UserWithJackson.class);
        System.out.println(user.age);
        System.out.println(user.birthDate);


    }
}
