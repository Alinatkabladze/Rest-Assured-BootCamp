package Jackson.JsonInclude.Default;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Getter
@Setter
public class Employee {
    private String name;
    private String dept;
    private Integer salary;
    private boolean fullTime;
    private List<String> phones;
    private Date dateOfBirth;

}
