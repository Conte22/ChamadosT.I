/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gabriel.conte
 */
public class ModelSetor {

    private int idSetor;
    private String nomeSetor;
    private String ramal;

    public ModelSetor() {
    }

    public ModelSetor(int idSetor, String nomeSetor, String ramal) {
        this.idSetor = idSetor;
        this.nomeSetor = nomeSetor;
        this.ramal = ramal;
    }

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }
}