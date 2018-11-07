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
public class Movimentacao {
    private String dthora;
    private int codprod;
    private char operacao;
    private int qntd;
    private Double vlunit;
    private int qntd_atual;

    public String getDthora() {
        return dthora;
    }

    public void setDthora(String dthora) {
        this.dthora = dthora;
    }

    public int getCodprod() {
        return codprod;
    }

    public void setCodprod(int codprod) {
        this.codprod = codprod;
    }

    public char getOperacao() {
        return operacao;
    }

    public void setOperacao(char operacao) {
        this.operacao = operacao;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }

    public Double getVlunit() {
        return vlunit;
    }

    public void setVlunit(Double vlunit) {
        this.vlunit = vlunit;
    }

    public int getQntd_atual() {
        return qntd_atual;
    }

    public void setQntd_atual(int qntd_atual) {
        this.qntd_atual = qntd_atual;
    }
    
    
}
