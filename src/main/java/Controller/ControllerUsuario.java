
package Controller;

import dao.UsuarioDAO;
import dao.UsuarioDAOjdbc;
import Model.Usuario;
import java.sql.SQLException;

public class ControllerUsuario {

    // Utiliza o DAO para acessar os usuários
    private final UsuarioDAO usuarioDAO = new UsuarioDAOjdbc();

    // Realiza o login do usuário
    public Usuario autenticar(String login) {
        try {
            return usuarioDAO.autenticar(login);

        } catch (SQLException erro) {
            javax.swing.JOptionPane.showMessageDialog(
                    null, "Erro ao autenticar usuário: " + erro.getMessage()
            );
            return null;
        }
    }

    // Salva um novo usuário
    public void salvar(String nome, String login) {
        try {
            usuarioDAO.salvar(nome, login);

        } catch (SQLException erro) {
            javax.swing.JOptionPane.showMessageDialog(
                    null, "Erro ao salvar usuário: " + erro.getMessage()
            );
        }
    }

    // Verifica se o login foi preenchido
    public String validar(String login) {

        if (login == null || login.trim().isEmpty()) {
            return "Informe o login.";
        }

        return null;
    }
}
