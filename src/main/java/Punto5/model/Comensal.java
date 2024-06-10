package Punto5.model;

public class Comensal {
    private String nombreDeComensal;
    public Comensal (String nombreDeComensal){
        this.nombreDeComensal = nombreDeComensal;
    }
    public void realizarPedido(Plato plato1, Bebida bebida1, Mesa mesa) {
        var pedido = new Pedido(bebida1, plato1);
        mesa.agregarPedido(pedido);
    }
}
