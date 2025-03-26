package org.JavaCar;

// Classe Furgoneta
public class Furgoneta extends Vehicle {
    private int capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase, int capacitatCarga, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }

    public int getCapacitatCarga() { return capacitatCarga; }

    @Override
    public double calcularPreu(int dies) {
        double extra = (capacitatCarga > 1000) ? 10 : 0;
        return (preuBase + extra) * dies;
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacitat de Càrrega: " + capacitatCarga + "kg";
    }
}
