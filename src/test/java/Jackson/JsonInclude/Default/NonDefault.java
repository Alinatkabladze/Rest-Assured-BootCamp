package Jackson.JsonInclude.Default;

import Jackson.JsonInclude.Default.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;


public class NonDefault {
    @Test
      public void test() throws JsonProcessingException {
            Employee employee = new Employee();
            employee.setName("Trish");
            employee.setFullTime(false);
            employee.setPhones(new ArrayList<>());
            employee.setSalary(Integer.valueOf(0));
            employee.setDateOfBirth(new Date(0));

            ObjectMapper om = new ObjectMapper();
            String jsonString = om.writeValueAsString(employee);
            System.out.println(jsonString);

    }
}
