// SeleccionMenuUI.java
package Punto5.ui;

import Punto5.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PantallaMenu extends JFrame {
    private Restaurante restaurante;
    private List<Plato> platos;
    private List<Bebida> bebidas;
    private Tarjeta tarjeta;
    private Mesa mesa;
    private List<Observer>observers;
    private JComboBox<String> comboPlatos;
    private JComboBox<String> comboBebidas;
    private JTextField cantidadPlatos;
    private JTextField cantidadBebidas;
    private JButton btnAgregar;
    private JButton btnPagar;

    public PantallaMenu(Restaurante restaurante, List<Plato> platos, List<Bebida> bebidas,  Integer capacidadMesa, Tarjeta tarjeta, List<Observer> observers) {
        this.restaurante = restaurante;
        this.platos = platos;
        this.bebidas = bebidas;
        this.tarjeta = tarjeta;
        this.observers = observers;

        this.mesa = new Mesa(capacidadMesa, observers);
        restaurante.agregarMesa(mesa);

        setTitle("Seleccionar Menú");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));

        comboPlatos = new JComboBox<>();
        comboBebidas = new JComboBox<>();
        cantidadPlatos = new JTextField();
        cantidadBebidas = new JTextField();
        btnAgregar = new JButton("Agregar Pedido");
        btnPagar = new JButton("Pagar");

        add(new JLabel("Plato:"));
        add(comboPlatos);
        add(new JLabel("Cantidad de Platos:"));
        add(cantidadPlatos);
        add(new JLabel("Bebida:"));
        add(comboBebidas);
        add(new JLabel("Cantidad de Bebidas:"));
        add(cantidadBebidas);
        add(btnAgregar);
        add(btnPagar);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPedido();
            }
        });

        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPago();
            }
         });

        cargarMenu();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void cargarMenu() {
        for (Plato plato : platos) {
            comboPlatos.addItem(plato.getNombreDePlato());
         }

        for (Bebida bebida : bebidas) {
            comboBebidas.addItem(bebida.getNombre());
        }
    }
    private void agregarPedido() {
        String platoSeleccionado = (String) comboPlatos.getSelectedItem();
        String bebidaSeleccionada = (String) comboBebidas.getSelectedItem();
        int cantidadPlato = Integer.parseInt(cantidadPlatos.getText());
        int cantidadBebida = Integer.parseInt(cantidadBebidas.getText());

        double valorPlato = obtenerValorPlato(platoSeleccionado);
        double valorBebida = obtenerValorBebida(bebidaSeleccionada);

        for (int i = 0; i < cantidadPlato; i++) {
            Pedido pedido = new Pedido(new Bebida(bebidaSeleccionada, valorBebida), new Plato(platoSeleccionado, valorPlato));
            mesa.agregarPedido(pedido);
        }

        for (int i = 0; i < cantidadBebida; i++) {
            Pedido pedido = new Pedido(new Bebida(bebidaSeleccionada, valorBebida), new Plato(platoSeleccionado, valorPlato));
            mesa.agregarPedido(pedido);
        }
    }

    //    private void agregarPedido() {
//        String platoSeleccionado = (String) comboPlatos.getSelectedItem();
//        String bebidaSeleccionada = (String) comboBebidas.getSelectedItem();
//        int cantidadPlato = Integer.parseInt(cantidadPlatos.getText());
//        int cantidadBebida = Integer.parseInt(cantidadBebidas.getText());
//
//        for (int i = 0; i < cantidadPlato; i++) {
//            mesa.agregarPedido(new Pedido(new Bebida(bebidaSeleccionada, obtenerValorBebida(bebidaSeleccionada)),
//                    new Plato(platoSeleccionado, obtenerValorPlato(platoSeleccionado))));
//        }
//
//        for (int i = 0; i < cantidadBebida; i++) {
//            mesa.agregarPedido(new Pedido(new Bebida(bebidaSeleccionada, obtenerValorBebida(bebidaSeleccionada)),
//                    new Plato(platoSeleccionado, obtenerValorPlato(platoSeleccionado))));
//        }
//    }
    private double obtenerValorPlato(String nombrePlato) {
        for (Plato plato : platos) {
            if (plato.getNombreDePlato().equals(nombrePlato)) {
                System.out.print(+plato.getValor());
                return plato.getValor();
            }
        }
        throw new RuntimeException("Plato no encontrado: " + nombrePlato);
    }

    private double obtenerValorBebida(String nombreBebida) {
        for (Bebida bebida : bebidas) {
            if (bebida.getNombre().equals(nombreBebida)) {
                return bebida.getValor();
            }
        }
        throw new RuntimeException("Bebida no encontrada: " + nombreBebida);
    }

//    private double obtenerValorPlato(String nombrePlato) {
//        for (Plato plato: this.platos){
//            if (plato.getNombreDePlato().equals(nombrePlato)){
//                return plato.getValor();
//            }
//        }
//        throw new RuntimeException("");
//    }
//
//    private double obtenerValorBebida(String nombreBebida) {
//        for (Bebida bebida: this.bebidas){
//            if (bebida.getNombre().equals(nombreBebida)){
//                return bebida.getValor();
//            }
//        }
//        throw new RuntimeException("");
//    }

    private void realizarPago() {
        double total = mesa.realizarPago(tarjeta, 10);

        JOptionPane.showMessageDialog(this, "Total pagado: " + total);
    }
}

//// GerenteUI.java
//package Punto5.ui;
//
//import Punto5.model.ObservadorMonto;
//
//import javax.swing.*;
//        import java.awt.*;

//public class GerenteUI extends JFrame {
//    private JLabel labelMonto;
//
//    public GerenteUI() {
//        setTitle("Pantalla del Gerente");
//        setSize(400, 100);
//        setLayout(new FlowLayout());
//
//        labelMonto = new JLabel("Monto total facturado: 0");
//        add(labelMonto);
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//    }
//
//    public ObservadorMonto getObservador() {
//        return new ObservadorMonto(labelMonto);
//    }
//}

//// Main.java
//package Punto5.main;
//
//import Punto5.model.Mesa;
//import Punto5.model.Restaurante;
//import Punto5.ui.GerenteUI;
//import Punto5.ui.SeleccionMenuUI;
//
//public class Main {
//    public static void main(String[] args) {
//        Restaurante restaurante = new Restaurante("Restaurante ABC");
//        Mesa mesa = new Mesa(4);
//
//        GerenteUI gerenteUI = new GerenteUI();
//        SeleccionMenuUI seleccionMenuUI = new SeleccionMenuUI(restaurante, mesa, gerenteUI.getObservador());
//    }
//}

