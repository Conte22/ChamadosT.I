package dao;

import Model.Usuario;
import java.sql.SQLException;

// Define as operações de acesso aos usuários
public interface UsuarioDAO {

    // Realiza a autenticação do usuário
    Usuario autenticar(String login, String senha) throws SQLException;

    // Salva um novo usuário no banco de dados
    void salvar(String nome, String login, String senha) throws SQLException;
}