package Lombok;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WithLombokUser {
    @NonNull
    private String firstName;
    private String lastName;
    private int totalPrice;

}
