package co.edu.javeriana.as.personapp.model.request;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DeleteTelefonoRequest {
    @NotNull
    private String id;
    @NotNull
    private  String database;
}