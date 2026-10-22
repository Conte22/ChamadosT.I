package com.mycompany.chamadost.i;

import Controller.ControllerSetor;
import Model.ModelSetor;
import Telas.TelaMenuInicial;
import java.util.List;

public class ChamadosTI {

    public static void main(String[] args) {
        try {
            ControllerSetor controller = new ControllerSetor();

            ModelSetor novoSetor = new ModelSetor(0, "Suporte T.I.", "1001");
            controller.cadastrarSetor(novoSetor);
            System.out.println(">>> SUCESSO: Setor inserido com sucesso no PostgreSQL! <<<");

            List<ModelSetor> setores = controller.listarSetores();
            System.out.println("\n--- Lista de Setores no Banco ---");
            for (ModelSetor s : setores) {
                System.out.println("ID: " + s.getIdSetor() + " | Nome: " + s.getNomeSetor() + " | Ramal: " + s.getRamal());
            }

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TelaMenuInicial().setVisible(true);
                }
            });

        } catch (Exception e) {
            System.err.println(">>> ERRO NA CONEXAO OU EXECUCAO: " + e.getMessage());
            e.printStackTrace();
        }
    }
}