package Punto5.ui;

import Punto5.model.Observer;

import javax.swing.*;
import java.awt.*;

public class PantallaGerente extends JFrame implements Observer {
    private JLabel montoFacturadoLabel;
    private int montoFacturado = 0;

    public PantallaGerente() {
        setTitle("Gerente");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        montoFacturadoLabel = new JLabel("Monto Facturado: $0");
        montoFacturadoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(montoFacturadoLabel, BorderLayout.CENTER);
    }



    @Override
    public void actualizar(double valor) {
        montoFacturado += valor;
        montoFacturadoLabel.setText("Monto Facturado: $" + montoFacturado);
        if (montoFacturado > 300000) {
            montoFacturadoLabel.setForeground(Color.RED);
        } else {
            montoFacturadoLabel.setForeground(Color.BLACK);
        }
    }
}
