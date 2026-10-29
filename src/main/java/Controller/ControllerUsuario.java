package Controller;

import dao.UsuarioDAO;
import dao.UsuarioDAOjdbc;
import Model.Usuario;
import java.sql.SQLException;

public class ControllerUsuario {

    private final UsuarioDAO usuarioDAO = new UsuarioDAOjdbc();

    public Usuario autenticar(String login, String senha) {
        try {
            return usuarioDAO.autenticar(login, senha);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao autenticar usuário: " + ex.getMessage());
            return null;
        }
    }

    public void salvar(String nome, String login, String senha) {
        try {
            usuarioDAO.salvar(nome, login, senha);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao salvar usuário: " + ex.getMessage());
        }
    }

    public String validar(String login, String senha) {
        if (login == null || login.trim().isEmpty()) {
            return "Informe o login.";
        }
        if (senha == null || senha.isEmpty()) {
            return "Informe a senha.";
        }
        return null;
    }
}