package Jackson.SerializerAndDeserializer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class UserWithJackson {
    @JsonPropertyOrder(
            {"name", "age", "email", "password", "lastName"}
    )

    @JsonInclude(JsonInclude.Include.NON_NULL)
   // @JsonProperty("name")
            //UserCustomerId
            //customerId
    public String name,
            lastName,
            email,
            password;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public int age;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime registrationDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime birthDate;
}
