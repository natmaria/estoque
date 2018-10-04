/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author nmpetry
 */
public class Secao {
    private int id;
    private String nome;
    private double tamanho;
    private int status;
    private String dt_inativado;

    public String getDt_inativado() {
        return dt_inativado;
    }

    public void setDt_inativado(String dt_inativado) {
        this.dt_inativado = dt_inativado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
