/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chamadost.i;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gabriel.conte
 */
public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/Chamados";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres"; // Insira a sua senha do PostgreSQL aqui

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}