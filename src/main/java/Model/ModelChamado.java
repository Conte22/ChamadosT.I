/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author gabriel.conte
 */
public class ModelChamado {

    private int idChamado;
    private int idFuncionario;
    private int idSetor;
    private String tipoImpacto;
    private String descricao;
    private String status;
    private LocalDateTime dataAbertura;

    public ModelChamado() {
    }

    public ModelChamado(int idChamado,
                int idFuncionario, 
                int idSetor, 
                String tipoImpacto, 
                String descricao, 
                String status, 
                LocalDateTime dataAbertura) 
    {
        this.idChamado = idChamado;
        
        this.idFuncionario = idFuncionario;
        
        this.idSetor = idSetor;
        
        this.tipoImpacto = tipoImpacto;
        
        this.descricao = descricao;
        
        this.status = status;
        
        this.dataAbertura = dataAbertura;
    }

    public int getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(int idChamado) {
        this.idChamado = idChamado;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }

    public String getTipoImpacto() {
        return tipoImpacto;
    }

    public void setTipoImpacto(String tipoImpacto) {
        this.tipoImpacto = tipoImpacto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}