package Punto5.model;

import java.util.ArrayList;
import java.util.List;

public class Mesa extends Observador{
    private Integer capacidadDeLaMesa;
    private List<Comensal> comensales;
    private List <Pedido> pedidos;
    private double propina;
    public Mesa (Integer capacidad, List<Observer> observadores) {
        super(observadores);
        this.capacidadDeLaMesa = capacidad;
        this.comensales = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }
    public double realizarPago(Tarjeta tarjeta, double porcentajePropina) {
        double valorBebida = 0;
        double valorComida = 0;
        double totalDescontado = 0;
        if (porcentajePropina > 0) {
            for (Pedido pedido : pedidos) {
                valorBebida += pedido.obtenerValorBebida();
                valorComida += pedido.obtenerValorPlato();
            }
            double propina = (valorBebida + valorComida) * (porcentajePropina / 100);
            totalDescontado = tarjeta.descuento(valorBebida, valorComida, propina);
            juntarPropina(propina);
            actualizar(totalDescontado);
        }
        return totalDescontado;
    }
    public void agregarComensal  (Comensal unComensal){
        if (comensales.size() <=  capacidadDeLaMesa){
            comensales.add(unComensal);
        }
    }
    public void agregarPedido (Pedido pedido){
        pedidos.add(pedido);
    }

    private void juntarPropina (double propina){
        this.propina += propina;
    }
    public Comensal obtenerComensal(Comensal comensal){
        for (Comensal comenzal: this.comensales){
            if (comenzal.equals(comensal)){
                return comensal;
            }
        }
        throw new RuntimeException("MAL");
    }
}

