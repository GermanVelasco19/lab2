package co.edu.javeriana.as.personapp.model.request;

import co.edu.javeriana.as.personapp.domain.Study;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProfesionRequest {
    @NotNull
    private Integer identification;

    @NotNull
    private String name;

    private String description;
    @ToString.Exclude
    private List<Study> studies;
    @NotNull
    private String database;
}
