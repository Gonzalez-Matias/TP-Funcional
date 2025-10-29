package org.src.ejercicio4;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    private String nombre;
    private String departamento;
    private double salario;
    private int edad;
}

