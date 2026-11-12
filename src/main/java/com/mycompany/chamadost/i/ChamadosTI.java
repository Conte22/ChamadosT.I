
package com.mycompany.chamadost.i;

import Telas.TelaLogin;

public class ChamadosTI {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            TelaLogin tela = new TelaLogin();
            tela.setVisible(true);
        });
    }
}
