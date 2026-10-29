package dao;

import com.mycompany.chamadost.i.Conexao;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOjdbc implements UsuarioDAO {

    private static final String SQL_SALVAR
            = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";

    private static final String SQL_AUTENTICAR
            = "SELECT id, nome, login FROM usuario WHERE login = ? AND senha = ?";

    @Override
    public Usuario autenticar(String login, String senha) throws SQLException {
        try (Connection conexao = Conexao.conectar();
             PreparedStatement comando = conexao.prepareStatement(SQL_AUTENTICAR)) {

            comando.setString(1, login);
            comando.setString(2, senha);

            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    return mapearUsuario(resultado);
                }
                return null;
            }
        }
    }

    @Override
    public void salvar(String nome, String login, String senha) throws SQLException {
        try (Connection conexao = Conexao.conectar();
             PreparedStatement comando = conexao.prepareStatement(SQL_SALVAR)) {

            comando.setString(1, nome);
            comando.setString(2, login);
            comando.setString(3, senha);
            comando.executeUpdate();
        }
    }

    private Usuario mapearUsuario(ResultSet resultado) throws SQLException {
        Usuario usuario = new Usuario(
                resultado.getString("nome"),
                resultado.getString("login")
        );
        usuario.setCodigo(resultado.getInt("id"));
        return usuario;
    }
}