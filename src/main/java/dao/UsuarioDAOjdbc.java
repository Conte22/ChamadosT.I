
package dao;

import Model.Usuario;
import com.mycompany.chamadost.i.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOjdbc implements UsuarioDAO {

    private static final String SQL_SALVAR =
            "INSERT INTO usuario (nome, login, senha, tipo) VALUES (?, ?, ?, 'COMUM')";

    private static final String SQL_AUTENTICAR =
            "SELECT id, nome, login, senha, tipo FROM usuario WHERE login = ? AND senha = ?";

    @Override
    public void salvar(String nome, String login) throws SQLException {
        try (Connection conexao = Conexao.getConexao();
             PreparedStatement comando = conexao.prepareStatement(SQL_SALVAR)) {

            comando.setString(1, nome);
            comando.setString(2, login);

            comando.executeUpdate();
        }
    }

    @Override
    public Usuario autenticar(String login) throws SQLException {
        return null;
    }

    public Usuario autenticar(String login, String senha) throws SQLException {

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement comando = conexao.prepareStatement(SQL_AUTENTICAR)) {

            comando.setString(1, login);
            comando.setString(2, senha);

            try (ResultSet resultado = comando.executeQuery()) {

                if (resultado.next()) {
                    Usuario usuario = new Usuario(
                            resultado.getString("nome"),
                            resultado.getString("login")
                    );

                    usuario.setCodigo(resultado.getInt("id"));
                    usuario.setSenha(resultado.getString("senha"));
                    usuario.setTipo(resultado.getString("tipo"));

                    return usuario;
                }
            }
        }

        return null;
    }
}
