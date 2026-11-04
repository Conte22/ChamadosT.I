
package dao;

import Model.Usuario;
import com.mycompany.chamadost.i.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Implementa as operações de acesso aos usuários
public class UsuarioDAOjdbc implements UsuarioDAO {

    // Comando para cadastrar um usuário
    private static final String SQL_SALVAR =
            "INSERT INTO usuario (nome, login) VALUES (?, ?)";

    // Comando para localizar um usuário pelo login
    private static final String SQL_AUTENTICAR =
            "SELECT id, nome, login FROM usuario WHERE login = ?";

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

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement comando = conexao.prepareStatement(SQL_AUTENTICAR)) {

            comando.setString(1, login);

            try (ResultSet resultado = comando.executeQuery()) {

                if (resultado.next()) {
                    Usuario usuario = new Usuario(
                            resultado.getString("nome"),
                            resultado.getString("login")
                    );

                    usuario.setCodigo(resultado.getInt("id"));

                    return usuario;
                }
            }
        }

        return null;
    }
}
