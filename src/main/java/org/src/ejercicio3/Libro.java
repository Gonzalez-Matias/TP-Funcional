package org.src.ejercicio3;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    private String titulo;
    private String autor;
    private int paginas;
    private double precio;
}
