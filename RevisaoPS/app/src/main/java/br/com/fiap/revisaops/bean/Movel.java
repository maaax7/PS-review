package br.com.fiap.revisaops.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MaaaXSantos on 5/31/16.
 */
public class Movel {
    private String nome;
    private float valor;

    public Movel(String _nome, float _valor){
        this.nome = _nome;
        this.valor = _valor;
    }

    public void setNome(String _nome){
        this.nome = _nome;
    }
    public String getNome(){
        return this.nome;
    }

    public void setValor(float _valor){
        this.valor = _valor;
    }
    public float getValor(){
        return this.valor;
    }

    public String toString(){
        return "Descrição: " + this.nome + "\n Valor: " + this.valor;
    }
}
