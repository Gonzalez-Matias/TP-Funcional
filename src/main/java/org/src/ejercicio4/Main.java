package org.src.ejercicio4;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado("Juan Pérez", "Ventas", 2500.0, 35));
        empleados.add(new Empleado("Ana Gómez", "Ventas", 1900.0, 28));
        empleados.add(new Empleado("Carlos Ruiz", "IT", 3200.0, 41));
        empleados.add(new Empleado("Lucía Fernández", "IT", 2800.0, 30));
        empleados.add(new Empleado("Marcos Díaz", "Recursos Humanos", 2100.0, 45));
        empleados.add(new Empleado("Sofía López", "Recursos Humanos", 1800.0, 26));
        empleados.add(new Empleado("Diego Torres", "IT", 4000.0, 23));

        System.out.println("Los empleados con salario mayor a $2000 son:");
        empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .map(empleado -> empleado.getNombre() + " con un salario de $" + empleado.getSalario())
                .forEach(System.out::println);

        double promedioSalario = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);
        System.out.println("\nEl salario promedio es: $" + Math.round(promedioSalario));

        System.out.println("\nLa cantidad total acumulada de salarios por departamento es:");
        Map<String, Double> totalPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));
        totalPorDepto.forEach((depto, total) ->
                System.out.println("El departamento " + depto + " acumula un salario de $" + total)
        );

        System.out.println("\nLos 2 empleados mas jóvenes son;");
        empleados.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .map(Empleado::getNombre)
                .forEach(System.out::println);
    }
}
