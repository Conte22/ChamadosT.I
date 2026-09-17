/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author gabriel.conte
 */

import Model.ModelSetor;
import com.mycompany.chamadost.i.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerSetor {

    public void salvar(ModelSetor s) throws SQLException {
        String sql = "INSERT INTO setor (nome_setor, ramal) VALUES (?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, s.getNomeSetor());
            stmt.setString(2, s.getRamal());
            stmt.executeUpdate();
        }
    }

    public List<ModelSetor> listar() throws SQLException {
        List<ModelSetor> lista = new ArrayList<>();
        String sql = "SELECT * FROM setor";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new ModelSetor(rs.getInt("id_setor"), rs.getString("nome_setor"), rs.getString("ramal")));
            }
        }
        return lista;
    }
}