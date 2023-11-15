package co.edu.javeriana.as.personapp.terminal.model;

import co.edu.javeriana.as.personapp.domain.Study;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ProfesionModeloCli {
    @NonNull
    private Integer identification;
    @NonNull
    private String name;
    private String description;
    @ToString.Exclude
    private List<Study> studies;
}
