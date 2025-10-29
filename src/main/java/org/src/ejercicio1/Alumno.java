package org.src.ejercicio1;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    private String nombre;
    private String curso;
    private final List<Float> notas = new ArrayList<>();

    public Alumno(String nombre, String curso, List<Float> notas) {
        this.nombre = nombre;
        this.curso = curso;
        this.notas.addAll(notas);
    }

    public Double getPromedio(){
        return notas.stream()
                .mapToDouble(Float::doubleValue)
                .average()
                .orElse(0.0);
    }
}
