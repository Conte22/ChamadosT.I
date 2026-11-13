package com.mycompany.chamadost.i;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/Chamados";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres"; // Insira a sua senha do PostgreSQL aqui

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public static Connection getConexao() throws SQLException {
        return conectar();
    }
}