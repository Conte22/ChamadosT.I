package dao;

import Model.Usuario;
import java.sql.SQLException;

// Define as operações de acesso aos usuários
public interface UsuarioDAO {

    // Realiza a autenticação pelo login
    Usuario autenticar(String login) throws SQLException;

    // Salva um novo usuário
    void salvar(String nome, String login) throws SQLException;
}
