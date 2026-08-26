package ni.edu.uam.registro_app.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Estudiante {
    private String nombres;
    private String apellidos;
    private String carrera;
    private LocalDate fechaNacimiento;
    private Boolean tieneBeca;
}
