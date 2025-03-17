package org.JavaCar;

abstract class Vehicle {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected String motor;
    protected int rodes;

    public Vehicle(String matricula, String marca, String model, double preuBase, String motor, int rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
    }

    public abstract double calcularPreu();

    public String mostrarInfo() {
        return "Vehicle: " + marca + " " + model + "\n" +
                "Matrícula: " + matricula + "\n" +
                "Preu Base: " + preuBase + "€\n" +
                "Motor: " + motor + "\n" +
                "Rodes: " + rodes;
    }
}

class Cotxe extends Vehicle {
    private int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, String motor, int rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.nombrePlaces = nombrePlaces;
    }

    @Override
    public double calcularPreu() {
        return preuBase;
    }
}

class Moto extends Vehicle {
    private int cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, String motor, int rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularPreu() {
        return (cilindrada > 500) ? preuBase + 5 : preuBase;
    }
}

class Furgoneta extends Vehicle {
    private double capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase, double capacitatCarga, String motor, int rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }

    @Override
    public double calcularPreu() {
        return preuBase;
    }
}
