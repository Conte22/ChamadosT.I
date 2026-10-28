/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author gabriel.conte
 */

import Model.ModelChamado;
import com.mycompany.chamadost.i.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerChamado {

    public List<ModelChamado> listarComNomes() {
        List<ModelChamado> lista = new ArrayList<>();

        String sql = "SELECT c.id_chamado, c.impacto AS prioridade, c.descricao, "
                   + "c.status AS estado, s.nome_setor AS setor, f.nome AS funcionario "
                   + "FROM chamado c "
                   + "INNER JOIN setor s ON c.id_setor = s.id_setor "
                   + "INNER JOIN funcionario f ON c.id_funcionario = f.id_funcionario "
                   + "ORDER BY c.id_chamado";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ModelChamado c = new ModelChamado();
                c.setIdChamado(rs.getInt("id_chamado"));
                c.setTipoImpacto(rs.getString("prioridade"));
                c.setDescricao(rs.getString("descricao"));
                c.setStatus(rs.getString("estado"));
                c.setNomeSetor(rs.getString("setor"));
                c.setNomeFuncionario(rs.getString("funcionario"));

                lista.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar chamados com INNER JOIN: " + e.getMessage());
        }

        return lista;
    }
}