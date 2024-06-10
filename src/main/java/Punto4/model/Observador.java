package Punto4.model;

import java.util.List;

public class Observador {
    private List<Observer> observadores;

    public Observador(List<Observer> observadores) {
        this.observadores = observadores;
    }

    public void notificar(  String nombre, String gmailPartincipante) {
        this.observadores.stream().forEach((o) -> o.notificarInscripcion(nombre, gmailPartincipante));
    }
}
