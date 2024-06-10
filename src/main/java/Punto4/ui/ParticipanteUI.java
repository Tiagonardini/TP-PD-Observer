package Punto4.ui;
import Punto4.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class ParticipanteUI extends JFrame {
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField emailField;
    private JButton inscribirButton;
    private List<Observer> observers;

        public ParticipanteUI(List <Observer> observerList) {
            this.observers = observerList;
            iniciar();
        }

    private void iniciar() {

        Participante participante = new Participante("","", "",this.observers);
        // Configuración básica de la ventana
        setTitle("Formulario de Inscripción");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        // Etiquetas y campos de texto
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();

        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        inscribirButton = new JButton("Inscribir");
        inscribirButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                 var nombre = nombreField.getText();
                 var apellido = apellidoField.getText();
                 var email = emailField.getText();
                 participante.notificarInscripcion(nombre, apellido, email);
            }
        });

        // Agregar componentes al panel
        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(apellidoLabel);
        panel.add(apellidoField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(new JLabel()); // Espacio vacío
        panel.add(inscribirButton);

        // Agregar panel a la ventana
        add(panel);
        setVisible(true);
    }



    }

