package Controller;

import Model.ModelChamado;
import com.mycompany.chamadost.i.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerChamado {

    public void salvar(ModelChamado chamado) {
        String sql = "INSERT INTO chamado (id_funcionario, id_setor, tipo_impacto, descricao, status, data_abertura) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, chamado.getIdFuncionario());
            ps.setInt(2, chamado.getIdSetor());
            ps.setString(3, chamado.getTipoImpacto());
            ps.setString(4, chamado.getDescricao());
            ps.setString(5, chamado.getStatus());
            ps.setObject(6, chamado.getDataAbertura());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar chamado no banco de dados: " + e.getMessage(), e);
        }
    }

    public List<ModelChamado> listarComNomes() {
        List<ModelChamado> lista = new ArrayList<>();

        String sql = "SELECT c.id_chamado, c.tipo_impacto AS prioridade, c.descricao, "
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
            System.err.println("Erro ao listar chamados com nomes: " + e.getMessage());
        }

        return lista;
    }
}