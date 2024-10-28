package br.edu.fateczl.ingressos.model;
/*
 *@author:<Gustavo de Paula>
 */
public class IngressoVIP extends Ingresso{

        private String funcao;

        public float valorFinal(float valorTaxa){
            return (float) (super.valorFinal(valorTaxa) * 0.18);
        }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
