package Meeting4;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class WithLombokUser {
    @NonNull
    private String firstName;
    private String lastName;
    private int totalPrice;

}
