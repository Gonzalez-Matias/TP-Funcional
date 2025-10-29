package org.src.ejercicio1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();

        List<Float> notas1 = Arrays.asList(8.5f, 9.0f, 7.5f, 10.0f, 8.0f);
        List<Float> notas2 = Arrays.asList(6.0f, 7.0f, 7.5f, 8.0f, 6.5f);
        List<Float> notas3 = Arrays.asList(9.0f, 8.5f, 9.5f, 10.0f, 8.0f);
        List<Float> notas4 = Arrays.asList(5.0f, 6.0f, 5.5f, 7.0f, 6.5f);
        List<Float> notas5 = Arrays.asList(10.0f, 9.5f, 9.0f, 10.0f, 9.8f);

        alumnos.add(new Alumno("Juan Pérez", "Matemática", notas1));
        alumnos.add(new Alumno("Ana López", "Matemática", notas2));
        alumnos.add(new Alumno("Carlos Ruiz", "Historia", notas3));
        alumnos.add(new Alumno("Lucía Fernández", "Historia", notas4));
        alumnos.add(new Alumno("Marcos Gómez", "Matemática", notas5));

        System.out.println("Los alumnos con un promedio superior a 7 son:");
        alumnos.stream()
                .filter(alumno -> alumno.getPromedio() >= 7)
                .map(alumno -> alumno.getNombre() + " que tiene un promedio de " + Math.round(alumno.getPromedio()))
                .forEach(System.out::println);

        float promedioTotal = (float) alumnos.stream()
                .mapToDouble(Alumno::getPromedio)
                .average()
                .orElse(0.0);
        System.out.println("\nEl promedio de notas de los alumnos es: " + Math.round(promedioTotal));

        System.out.println("\nLa cantidad el alumnos por curso es:");
        Map<String, List<Alumno>> alumnosCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

        alumnosCurso.forEach((curso, alumnosLista) -> {
            int numAlumnos = alumnosLista.size();
            System.out.println("El curso " + curso + " tiene " + numAlumnos + " alumnos");
        });

        System.out.println("\nLos mejores 3 promedios son:");
        alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getPromedio).reversed())
                .limit(3)
                .map(alumno -> alumno.getNombre() + " que posee un promedio de " + Math.round(alumno.getPromedio()) + " en el curso de " + alumno.getCurso())
                .forEach(System.out::println);



    }
}