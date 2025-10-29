package org.src.ejercicio3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Libro> libros = new ArrayList<>();

        libros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 471, 25.0));
        libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 96, 10.0));
        libros.add(new Libro("1984", "George Orwell", 328, 18.5));
        libros.add(new Libro("Fahrenheit 451", "Ray Bradbury", 249, 15.0));
        libros.add(new Libro("Crimen y castigo", "Fiódor Dostoievski", 671, 30.0));
        libros.add(new Libro("Rebelión en la granja", "George Orwell", 112, 12.0));
        libros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 863, 40.0));

        System.out.println("Los libros con mas de 300 paginas son:");
        libros.stream()
                .filter(l -> l.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .forEach(System.out::println);

        double promedioPaginas = libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0.0);
        System.out.println("\nEl promedio de páginas es: " + Math.round(promedioPaginas));

        System.out.println("\nLa cantidad de libros de cada autor son:");
        Map<String, Long> librosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(
                        Libro::getAutor,
                        Collectors.counting()
                ));
        librosPorAutor.forEach((autor, cantidad) ->
                System.out.println("El autor " + autor + " tiene " + cantidad + " libro(s)")
        );

        System.out.println("\nEl libro mas caro es:");
        libros.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio))
                .map(libro -> libro.getTitulo() + " que cuesta $" + libro.getPrecio())
                .ifPresent(System.out::println);
    }
}
