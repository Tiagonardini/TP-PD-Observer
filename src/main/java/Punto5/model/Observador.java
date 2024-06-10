package Punto5.model;

import java.util.List;

public class Observador implements Observer{
    public List<Observer> observadores;

    public Observador(List<Observer> observadores){
        this.observadores = observadores;
    }

    @Override
    public void actualizar(double monto) {
        this.observadores.stream().forEach((o) -> o.actualizar(monto));

    }
}
