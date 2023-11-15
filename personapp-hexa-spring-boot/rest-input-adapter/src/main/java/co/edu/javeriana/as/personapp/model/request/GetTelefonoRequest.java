package co.edu.javeriana.as.personapp.model.request;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetTelefonoRequest {
    @NotNull
    private String Id;
    @NotNull
    private String database;
}
