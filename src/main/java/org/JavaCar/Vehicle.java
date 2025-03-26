package org.JavaCar;


// Classe Abstracta Vehicle
public abstract class Vehicle implements Llogable {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes;

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
    }

    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public String getModel() { return model; }
    public double getPreuBase() { return preuBase; }
    public Motor getMotor() { return motor; }
    public Roda[] getRodes() { return rodes; }

    @Override
    public String toString() {
        String rodesInfo = (rodes != null && rodes.length > 0)
                ? rodes[0].toString() + " (x" + rodes.length + ")"
                : "Sense rodes";

        return "Matricula: " + matricula +
                ", Marca: " + marca +
                ", Model: " + model +
                ", Preu Base: " + preuBase +
                ", Motor: " + (motor != null ? motor.toString() : "Sense motor") +
                ", Rodes: " + rodesInfo;
    }
}
