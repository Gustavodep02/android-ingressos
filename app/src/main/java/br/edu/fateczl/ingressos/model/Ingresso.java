package br.edu.fateczl.ingressos.model;
/*
 *@author:<Gustavo de Paula>
 */
public class Ingresso {

    private String id;
    private float valor;

    public float valorFinal(float valorTaxa){
        return valor + valorTaxa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
