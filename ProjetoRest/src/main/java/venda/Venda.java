/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda;

import cliente.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import produto.Produto;

/**
 *
 * @author kaiqu
 */
@Entity
public class Venda implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produto> produtos;

    public Venda() {
    }

    public Venda(Cliente cliente, List<Produto> produtos) {
        this.cliente = cliente;
        this.produtos = new ArrayList<Produto>();
    }

    public Venda(long id, Cliente cliente, List<Produto> produtos) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = new ArrayList<Produto>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean addProduto(Produto p) {
        this.getProdutos().add(p);
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", cliente=" + cliente + ", produtos=" + produtos + '}';
    }

}
