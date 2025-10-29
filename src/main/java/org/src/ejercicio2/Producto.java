package org.src.ejercicio2;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
}