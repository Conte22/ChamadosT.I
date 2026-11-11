
package Controller;

import Model.ModelFuncionario;
import com.mycompany.chamadost.i.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerFuncionario {

    public void salvar(ModelFuncionario funcionario, String login, String senha) throws SQLException {

        String sqlFuncionario = "INSERT INTO funcionario (id_setor, nome, email, telefone) VALUES (?, ?, ?, ?)";
        String sqlUsuario = "INSERT INTO usuario (id_funcionario, nome, login, senha, tipo) VALUES (?, ?, ?, ?, 'COMUM')";

        try (Connection conexao = Conexao.getConexao()) {

            conexao.setAutoCommit(false);

            try {
                int idFuncionario;

                try (PreparedStatement comando = conexao.prepareStatement(
                        sqlFuncionario, PreparedStatement.RETURN_GENERATED_KEYS)) {

                    comando.setInt(1, funcionario.getIdSetorOrigem());
                    comando.setString(2, funcionario.getNome());
                    comando.setString(3, funcionario.getEmail());
                    comando.setString(4, funcionario.getTelefone());

                    comando.executeUpdate();

                    try (ResultSet resultado = comando.getGeneratedKeys()) {
                        if (resultado.next()) {
                            idFuncionario = resultado.getInt(1);
                        } else {
                            throw new SQLException("Não foi possível obter o ID do funcionário.");
                        }
                    }
                }

                try (PreparedStatement comando = conexao.prepareStatement(sqlUsuario)) {

                    comando.setInt(1, idFuncionario);
                    comando.setString(2, funcionario.getNome());
                    comando.setString(3, login);
                    comando.setString(4, senha);

                    comando.executeUpdate();
                }

                conexao.commit();

            } catch (SQLException erro) {
                conexao.rollback();
                throw erro;
            }
        }
    }

    public List<ModelFuncionario> listar() throws SQLException {

        List<ModelFuncionario> funcionarios = new ArrayList<>();

        String sql = "SELECT id_funcionario, id_setor, nome, email, telefone FROM funcionario";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {

                ModelFuncionario funcionario = new ModelFuncionario(
                        resultado.getInt("id_funcionario"),
                        resultado.getInt("id_setor"),
                        resultado.getString("nome"),
                        resultado.getString("email"),
                        resultado.getString("telefone")
                );

                funcionarios.add(funcionario);
            }
        }

        return funcionarios;
    }
}
