package com.mycompany.chamadost.i;

import Telas.TelaLogin;

public class ChamadosTI {

    public static void main(String[] args) {
        // Abre a tela de login ao iniciar o sistema
        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
}