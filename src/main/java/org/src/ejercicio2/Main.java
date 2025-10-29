package org.src.ejercicio2;

import org.src.ejercicio1.Alumno;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Notebook Lenovo", "Electrónica", 950.0, 10));
        productos.add(new Producto("Auriculares JBL", "Electrónica", 120.0, 25));
        productos.add(new Producto("Silla Gamer", "Muebles", 180.0, 5));
        productos.add(new Producto("Mouse Logitech", "Electrónica", 60.0, 30));
        productos.add(new Producto("Escritorio", "Muebles", 200.0, 3));
        productos.add(new Producto("Lámpara", "Decoración", 45.0, 8));

        System.out.println("Los productos que valen mas de $100 son:");
        productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .map(producto -> producto.getNombre() + " que vale $" + producto.getPrecio())
                .forEach(System.out::println);

        System.out.println("\nEl stock por categoría es:");
        Map<String, Integer> stockCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)
                ));
        stockCategoria.forEach((cat, stock) ->
                System.out.println("La categoría " + cat + " tiene un stock de: " + stock));


        System.out.println("\nLos productos y sus precios son:");
        String resumen = productos.stream()
                .map(p -> p.getNombre() + " $" + p.getPrecio())
                .collect(Collectors.joining("; "));
        System.out.println(resumen);

        double promedioGeneral = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);
        System.out.println("\nPromedio general: $" + Math.round(promedioGeneral));

        System.out.println("\nEl precio promedio por categoría es:");
        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));
        promedioPorCategoria.forEach((cat, prom) ->
                System.out.println("La categoría " + cat + " tiene un precio promedio de: $" + Math.round(prom)));
    }
}