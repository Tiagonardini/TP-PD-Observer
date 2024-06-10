package Punto4.main;

import Punto4.model.EmailObserver;
import Punto4.ui.ParticipanteUI;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().start();
            }
        });
    }

    private void start() {
        new ParticipanteUI(List.of(new EmailObserver())) ;
    }
}