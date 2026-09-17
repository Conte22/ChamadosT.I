/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gabriel.conte
 */
public class ModelFuncionario {

    private int idFuncionario;
    private int idSetorOrigem;
    private String nome;
    private String email;
    private String telefone;

    public ModelFuncionario() {
    }

    public ModelFuncionario(int idFuncionario,
                        int idSetorOrigem,
                        String nome, 
                        String email, 
                        String telefone) 
    {
        this.idFuncionario = idFuncionario;
        this.idSetorOrigem = idSetorOrigem;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdSetorOrigem() {
        return idSetorOrigem;
    }

    public void setIdSetorOrigem(int idSetorOrigem) {
        this.idSetorOrigem = idSetorOrigem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}