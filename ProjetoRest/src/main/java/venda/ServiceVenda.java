/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import produto.Produto;

/**
 *
 * @author kaiqu
 */
@Stateless
public class ServiceVenda {

    @PersistenceContext
    private EntityManager em;

    public Venda addProduto(int vendaId, int produtoId) {
        Venda venda = em.find(Venda.class, vendaId);
        Produto produto = em.find(Produto.class, produtoId);
        venda.addProduto(produto);
        return venda;
    }
}
