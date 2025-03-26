package org.JavaCar;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        // Preguntar si el usuario es Cliente o Administrador
        System.out.println("Selecciona el tipo de usuario:");
        System.out.println("1) Cliente");
        System.out.println("2) Administrador");
        System.out.print("Opcion: ");
        int userType = scanner.nextInt();
        scanner.nextLine();

        boolean Administrador = (userType == 2);

        int option;
        do {
            System.out.println("\n========= MENÚ =========\n" + "1) Listar todos los vehículos\n" + "2) Buscar vehículo por matrícula\n" + "3) Filtrar vehículos por tipo\n" + "4) Calcular precio de alquiler");
            if (Administrador) {
                System.out.println("5) Calcular ingresos totales\n" + "6) Añadir nuevo vehículo");
            }
            System.out.print("0) Salir\n" + "Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    listar_vehiculos(vehicles);
                    break;
                case 2:
                    buscar_matricula(vehicles, scanner);
                    break;
                case 3:
                    filtrar_tipo(vehicles, scanner);
                    break;
                case 4:
                    calcular_precio(vehicles, scanner);
                    break;
                case 5:
                    if (Administrador) {
                        calcular_ingresos_totales(vehicles, scanner);
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 6:
                    if (Administrador) {
                        añadir_nuevo_vehiculo(vehicles, scanner);
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 0);
    }

    private static void listar_vehiculos(List<Vehicle> vehicles) {
        System.out.println("\n========= LISTA DE VEHÍCULOS =========");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    private static void buscar_matricula(List<Vehicle> vehicles, Scanner scanner) {
        System.out.print("Ingrese la matrícula: ");
        String matricula = scanner.nextLine();
        for (Vehicle v : vehicles) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.println("Vehículo encontrado: " + v);
                return;
            }
        }
        System.out.println("No se encontró ningún vehículo con esa matrícula.");
    }

    private static void filtrar_tipo(List<Vehicle> vehicles, Scanner scanner) {
        System.out.println("Seleccione el tipo:\n" + "1) Coche\n" + "2) Moto\n" + "3) Furgoneta\n");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\n========= VEHÍCULOS FILTRADOS =========");
        for (Vehicle v : vehicles) {
            if ((tipo == 1 && v instanceof Cotxe) || (tipo == 2 && v instanceof Moto) || (tipo == 3 && v instanceof Furgoneta)) {
                System.out.println(v);
            }
        }
    }

    private static void calcular_precio(List<Vehicle> vehicles, Scanner scanner) {
        System.out.print("Ingrese la matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Ingrese la cantidad de días: ");
        int dias = scanner.nextInt();
        for (Vehicle v : vehicles) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.println("Precio total: " + v.calcularPreu(dias) + "€");
                return;
            }
        }
        System.out.println("No se encontró el vehículo.");
    }

    private static void calcular_ingresos_totales(List<Vehicle> vehicles, Scanner scanner) {
        System.out.print("Ingrese la cantidad de días: ");
        int dias = scanner.nextInt();
        double total = GestorLloguers.calcularIngressosTotals(vehicles, dias);
        System.out.println("Ingresos totales por " + dias + " días: " + total + "€");
    }

    private static void añadir_nuevo_vehiculo(List<Vehicle> vehicles, Scanner scanner) {
        System.out.println("\n========= AÑADIR NUEVO VEHÍCULO =========");
        System.out.println("Seleccione el tipo: 1. Coche 2. Moto 3. Furgoneta");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Ingrese la marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo: ");
        String model = scanner.nextLine();
        System.out.print("Ingrese el precio base: ");
        double preuBase = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese el tipo de motor: ");
        String tipusMotor = scanner.nextLine();
        System.out.print("Ingrese la potencia del motor: ");
        int potencia = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la cantidad de ruedas: ");
        int numRodes = scanner.nextInt();
        scanner.nextLine();

        Roda[] rodes = new Roda[numRodes];
        for (int i = 0; i < numRodes; i++) {
            System.out.print("Ingrese la marca de la rueda " + (i + 1) + ": ");
            String marcaRoda = scanner.nextLine();
            System.out.print("Ingrese el diámetro de la rueda " + (i + 1) + ": ");
            int diametre = scanner.nextInt();
            scanner.nextLine();
            rodes[i] = new Roda(marcaRoda, diametre);
        }

        Motor motor = new Motor(tipusMotor, potencia);

        switch (tipo) {
            case 1:
                System.out.print("Ingrese el número de plazas: ");
                int nombrePlaces = scanner.nextInt();
                scanner.nextLine();
                vehicles.add(new Cotxe(matricula, marca, model, preuBase, nombrePlaces, motor, rodes));
                break;
            case 2:
                System.out.print("Ingrese la cilindrada: ");
                int cilindrada = scanner.nextInt();
                scanner.nextLine();
                vehicles.add(new Moto(matricula, marca, model, preuBase, cilindrada, motor, rodes));
                break;
            case 3:
                System.out.print("Ingrese la capacidad de carga: ");
                int capacitatCarga = scanner.nextInt();
                scanner.nextLine();
                vehicles.add(new Furgoneta(matricula, marca, model, preuBase, capacitatCarga, motor, rodes));
                break;
        }
    }
}
