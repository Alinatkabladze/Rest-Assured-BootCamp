package Deserialize_new;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;


public record StudentRecord(@JsonProperty("Name") @NonNull String name,
                            @JsonProperty("Surname") @JsonInclude(JsonInclude.Include.NON_EMPTY) String surname,
                            @JsonProperty("City") String city) {
}
