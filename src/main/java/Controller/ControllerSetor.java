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
        String sql = "SELECT * FROM setor ORDER BY id_setor";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new ModelSetor(
                    rs.getInt("id_setor"), 
                    rs.getString("nome_setor"), 
                    rs.getString("ramal")
                ));
            }
        }
        return lista;
    }

    public void cadastrarSetor(ModelSetor novoSetor) throws SQLException {
        salvar(novoSetor);
    }

    public List<ModelSetor> listarSetores() throws SQLException {
        return listar();
    }
}