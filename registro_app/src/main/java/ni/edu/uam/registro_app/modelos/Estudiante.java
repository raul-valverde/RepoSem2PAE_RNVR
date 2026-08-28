package ni.edu.uam.registro_app.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Estudiante {
    private String nombres;
    private String apellidos;
    private String carrera;
    private LocalDate fechaNac;
    private Boolean tieneBeca;
    private String facultad; // <--- FALTABA ESTE CAMPO
    private String modalidad;
    private List<String> clubes;
}
