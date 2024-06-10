package Punto5.model;

public class Bebida {
    public String getNombre() {
        return nombre;
    }

    private String nombre;
    private double valor;

    public Bebida (String nombre, Double valor){
        this.nombre = nombre;
        this.valor = valor;
    }
    public double getValor(){
        return this.valor;
    }
}
