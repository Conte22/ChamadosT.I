
package com.mycompany.chamadost.i;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class Conexao {

    private static String URL;
    private static String USUARIO;
    private static String SENHA;

    static {
        carregarConfiguracao();
    }

    // Carrega os dados do arquivo config.properties
    private static void carregarConfiguracao() {
        try {
            Path local = Path.of(
                Conexao.class.getProtectionDomain()
                    .getCodeSource().getLocation().toURI()
            );

            Path pasta;

            if (local.toString().endsWith(".jar")) {
                pasta = local.getParent();
            } else {
                pasta = local.getParent();
            }

            Path arquivo = pasta.resolve("config.properties");

            Properties propriedades = new Properties();

            try (FileInputStream entrada =
                    new FileInputStream(arquivo.toFile())) {
                propriedades.load(entrada);
            }

            URL = propriedades.getProperty("url");
            USUARIO = propriedades.getProperty("usuario");
            SENHA = propriedades.getProperty("senha");

        } catch (Exception erro) {
            throw new RuntimeException(
                "Não foi possível carregar o arquivo config.properties.",
                erro
            );
        }
    }

    // Faz a conexão com o PostgreSQL
    public static Connection conectar() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (ClassNotFoundException erro) {
            throw new SQLException(
                "Driver JDBC do PostgreSQL não encontrado.", erro
            );
        }
    }

    // Retorna a conexão com o banco
    public static Connection getConexao() throws SQLException {
        return conectar();
    }
}
