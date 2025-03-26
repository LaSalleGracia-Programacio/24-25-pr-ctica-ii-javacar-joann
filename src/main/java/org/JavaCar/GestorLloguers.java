package org.JavaCar;

// Classe Estàtica GestorLloguers
import java.util.List;

public class GestorLloguers {
    public static double calcularIngressosTotals(List<Vehicle> vehicles, int dies) {
        return vehicles.stream().mapToDouble(v -> v.calcularPreu(dies)).sum();
    }
}
