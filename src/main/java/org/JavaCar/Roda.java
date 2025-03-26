package org.JavaCar;

// Classe Roda
public class Roda {
    private String marca;
    private int diametre;

    public Roda(String marca, int diametre) {
        this.marca = marca;
        this.diametre = diametre;
    }

    public String getMarca() { return marca; }
    public int getDiametre() { return diametre; }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Diàmetre: " + diametre + " polzades";
    }
}
