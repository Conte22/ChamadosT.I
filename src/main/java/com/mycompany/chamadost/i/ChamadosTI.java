package com.mycompany.chamadost.i;

import Telas.TelaLogin;

public class ChamadosTI {

    public static void main(String[] args) {
        // Inicia o sistema diretamente pela TelaLogin
        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
}