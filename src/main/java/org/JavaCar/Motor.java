package org.JavaCar;

// Classe Motor
public class Motor {
    private String tipus;
    private int potencia;

    public Motor(String tipus, int potencia) {
        this.tipus = tipus;
        this.potencia = potencia;
    }

    public String getTipus() { return tipus; }
    public int getPotencia() { return potencia; }

    @Override
    public String toString() {
        return "Tipus: " + tipus + ", Potència: " + potencia + "CV";
    }
}
