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
public class Produto {
   private int id;
   private String nome;
   private String info;
   private int grupo;
   private int qntd_min;
   private int status;
   private String data_add;
   private String dt_inativado;

    public String getData_add() {
        return data_add;
    }

    public void setData_add(String data_add) {
        this.data_add = data_add;
    }

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getQntd_min() {
        return qntd_min;
    }

    public void setQntd_min(int qntd_min) {
        this.qntd_min = qntd_min;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
   
}
