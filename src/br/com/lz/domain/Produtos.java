/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lz.domain;

/**
 *
 * @author felip
 */
public class Produtos {
    private String nome;
    private double preco;
    private int estoque;
    private int id;
    private String prodserv;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdserv() {
        return prodserv;
    }

    public void setProdserv(String prodserv) {
        this.prodserv = prodserv;
    }
}
