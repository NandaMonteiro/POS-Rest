/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author nanda
 */
@Path("produto")
//@Named
//@ApplicationScoped
@Stateless
public class ProdutoResource {
    
    @PersistenceContext(unitName = "com.mycompany_ProjetoRest_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @POST
    @Produces(MediaType.APPLICATION_XML)
    
    public Response salvarProduto(@BeanParam Produto produto){
        em.persist(produto);
        return Response.ok(produto).build();
    }
    
    @DELETE
    public Response removeProduto(@BeanParam Produto produto){
        em.remove(em.merge(produto));
        return Response.ok(produto).build();     
    }
    
    
    
}
