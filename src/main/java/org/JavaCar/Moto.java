package org.JavaCar;

public class Moto extends Vehicle {
    private int cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() { return cilindrada; }

    @Override
    public double calcularPreu(int dies) {
        double extra = (cilindrada > 500) ? 5 : 0;
        return (preuBase + extra) * dies;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cilindrada: " + cilindrada;
    }
}
