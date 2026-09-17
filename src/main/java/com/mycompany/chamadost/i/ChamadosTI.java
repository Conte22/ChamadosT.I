package com.mycompany.chamadost.i;

import Controller.ControllerSetor;
import Model.ModelSetor;
import java.util.List;

public class ChamadosTI {

    public static void main(String[] args) {
        try {
            ControllerSetor controller = new ControllerSetor();

            // 1. Testar inserção
            ModelSetor novoSetor = new ModelSetor(0, "Suporte T.I.", "1001");
            controller.cadastrarSetor(novoSetor);
            System.out.println(">>> SUCESSO: Setor inserido com sucesso no PostgreSQL! <<<");

            // 2. Testar leitura (SELECT)
            List<ModelSetor> setores = controller.listarSetores();
            System.out.println("\n--- Lista de Setores no Banco ---");
            for (ModelSetor s : setores) {
                System.out.println("ID: " + s.getIdSetor() + " | Nome: " + s.getNomeSetor() + " | Ramal: " + s.getRamal());
            }

        } catch (Exception e) {
            System.err.println(">>> ERRO NA CONEXAO OU EXECUCAO: " + e.getMessage());
            e.printStackTrace();
        }
    }
}