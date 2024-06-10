package Punto5.main;



import Punto5.model.*;
import Punto5.ui.PantallaGerente;
import Punto5.ui.PantallaMenu;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().iniciar();
        });
    }

    private void iniciar() {
        List<Plato> platosDelRestaurante = new ArrayList<>();
        List<Bebida> bebidasDelRestaurante = new ArrayList<>();

        var plato1 = new Plato("Fideos con salsa rosa", 5000.0);
        var plato2 = new Plato("Fideos con salsa verde", 6000.0);
        var plato3 = new Plato("Fideos con salsa azul", 7000.0);

        var bebida1 = new Bebida("Coca cola",2000.0);
        var bebida2 = new Bebida("Agua", 1000.0);

        var resto1 = new Restaurante("SALSEX");

        platosDelRestaurante.add(plato1);
        platosDelRestaurante.add(plato2);
        platosDelRestaurante.add(plato3);
        bebidasDelRestaurante.add(bebida1);
        bebidasDelRestaurante.add(bebida2);

        Comensal juan = new Comensal("Juan Villegas");

        Tarjeta tarjComarcaPlus = new TarjetaComarcaPlus(12345678, LocalDate.now().plusMonths(10), 50000.00, juan);



        new PantallaMenu(resto1, platosDelRestaurante, bebidasDelRestaurante, 1, tarjComarcaPlus, List.of(new PantallaGerente()));
    }
}
