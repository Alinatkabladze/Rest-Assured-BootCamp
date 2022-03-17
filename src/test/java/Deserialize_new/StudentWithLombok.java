package Deserialize_new;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class StudentWithLombok {

    private String name;
    private String lastNAme;
    private double height;
    private int age;
    private String University;

} 