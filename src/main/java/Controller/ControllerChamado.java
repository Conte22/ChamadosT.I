
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

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, chamado.getIdFuncionario());
            comando.setInt(2, chamado.getIdSetor());
            comando.setString(3, chamado.getTipoImpacto());
            comando.setString(4, chamado.getDescricao());
            comando.setString(5, chamado.getStatus());
            comando.setObject(6, chamado.getDataAbertura());

            comando.executeUpdate();

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao salvar chamado no banco de dados: " + erro.getMessage(), erro);
        }
    }

    public List<ModelChamado> listarComNomes() {
        List<ModelChamado> chamados = new ArrayList<>();

        String sql = "SELECT c.id_chamado, c.tipo_impacto AS prioridade, c.descricao, "
                   + "c.status AS estado, s.nome_setor AS setor, f.nome AS funcionario "
                   + "FROM chamado c "
                   + "INNER JOIN setor s ON c.id_setor = s.id_setor "
                   + "INNER JOIN funcionario f ON c.id_funcionario = f.id_funcionario "
                   + "ORDER BY c.id_chamado";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                ModelChamado chamado = new ModelChamado();

                chamado.setIdChamado(resultado.getInt("id_chamado"));
                chamado.setTipoImpacto(resultado.getString("prioridade"));
                chamado.setDescricao(resultado.getString("descricao"));
                chamado.setStatus(resultado.getString("estado"));
                chamado.setNomeSetor(resultado.getString("setor"));
                chamado.setNomeFuncionario(resultado.getString("funcionario"));

                chamados.add(chamado);
            }

        } catch (SQLException erro) {
            System.err.println("Erro ao listar chamados com nomes: " + erro.getMessage());
        }

        return chamados;
    }
}
