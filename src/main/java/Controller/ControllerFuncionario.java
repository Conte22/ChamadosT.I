/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ModelFuncionario;
import com.mycompany.chamadost.i.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel.conte
 */
public class ControllerFuncionario {

    public void salvar(ModelFuncionario f) throws SQLException {
        String sql = "INSERT INTO funcionario (id_setor, nome, email, telefone) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, f.getIdSetorOrigem());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getEmail());
            stmt.setString(4, f.getTelefone());
            stmt.executeUpdate();
        }
    }

    public List<ModelFuncionario> listar() throws SQLException {
        List<ModelFuncionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new ModelFuncionario(rs.getInt("id_funcionario"), rs.getInt("id_setor"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone")));
            }
        }
        return lista;
    }
}