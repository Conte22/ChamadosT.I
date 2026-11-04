
package Controller;

import Model.ModelSetor;
import com.mycompany.chamadost.i.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerSetor {

    public void salvar(ModelSetor setor) throws SQLException {
        String sql = "INSERT INTO setor (nome_setor, ramal) VALUES (?, ?)";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, setor.getNomeSetor());
            comando.setString(2, setor.getRamal());

            comando.executeUpdate();
        }
    }

    public List<ModelSetor> listar() throws SQLException {
        List<ModelSetor> setores = new ArrayList<>();

        String sql = "SELECT id_setor, nome_setor, ramal FROM setor ORDER BY id_setor";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                ModelSetor setor = new ModelSetor(
                    resultado.getInt("id_setor"),
                    resultado.getString("nome_setor"),
                    resultado.getString("ramal")
                );

                setores.add(setor);
            }
        }

        return setores;
    }

    public void cadastrarSetor(ModelSetor novoSetor) throws SQLException {
        salvar(novoSetor);
    }

    public List<ModelSetor> listarSetores() throws SQLException {
        return listar();
    }
}
