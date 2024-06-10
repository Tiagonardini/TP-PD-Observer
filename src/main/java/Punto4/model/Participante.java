package Punto4.model;

import java.util.List;

public class Participante extends Observador{
    private String nombre;
    private String apellido;
    private String email;

    public Participante(String nombre,String apellido,  String email, List<Observer> observadores) {
        super(observadores);
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public void notificarInscripcion(String nombre, String apellido, String gmail){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = gmail;
        super.notificar(nombre,gmail);
    }
}
