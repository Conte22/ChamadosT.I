package com.mycompany.chamadost.i;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // Dados de conexão com o banco
    private static final String URL = "jdbc:postgresql://localhost:5432/Chamados";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";

    // Faz a conexão com o PostgreSQL
    public static Connection conectar() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (ClassNotFoundException erro) {
            throw new SQLException("Driver JDBC do PostgreSQL não encontrado.", erro);
        }
    }

    // Retorna a conexão com o banco
    public static Connection getConexao() throws SQLException {
        return conectar();
    }
}