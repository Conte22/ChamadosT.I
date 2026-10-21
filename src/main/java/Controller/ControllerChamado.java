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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerChamado {

    public void salvar(ModelChamado c) throws SQLException {
        String sql = "INSERT INTO chamado (id_funcionario, id_setor, tipo_impacto, descricao, status, data_abertura) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, c.getIdFuncionario());
            stmt.setInt(2, c.getIdSetor());
            stmt.setString(3, c.getTipoImpacto());
            stmt.setString(4, c.getDescricao());
            stmt.setString(5, c.getStatus());
            stmt.setTimestamp(6, Timestamp.valueOf(c.getDataAbertura()));
            stmt.executeUpdate();
        }
    }

    public List<ModelChamado> listar() throws SQLException {
        List<ModelChamado> lista = new ArrayList<>();
        String sql = "SELECT * FROM chamado ORDER BY id_chamado DESC";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Timestamp ts = rs.getTimestamp("data_abertura");
                lista.add(new ModelChamado(
                    rs.getInt("id_chamado"),
                    rs.getInt("id_funcionario"),
                    rs.getInt("id_setor"),
                    rs.getString("tipo_impacto"),
                    rs.getString("descricao"),
                    rs.getString("status"),
                    ts != null ? ts.toLocalDateTime() : null
                ));
            }
        }
        return lista;
    }

    public void atualizarStatus(int idChamado, String novoStatus) throws SQLException {
        String sql = "UPDATE chamado SET status = ? WHERE id_chamado = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoStatus);
            stmt.setInt(2, idChamado);
            stmt.executeUpdate();
        }
    }
}
