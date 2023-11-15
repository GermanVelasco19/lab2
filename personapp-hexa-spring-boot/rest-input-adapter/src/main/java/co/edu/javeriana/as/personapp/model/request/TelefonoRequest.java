package co.edu.javeriana.as.personapp.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class TelefonoRequest {
    @NotNull
    private Integer num;
    @NotNull
    private String oper;
    @NotNull
    private Integer duenio;
    @NotNull
    private String database;

}
