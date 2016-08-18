/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author nanda
 */
@Path("cliente")
@Stateless
public class ClienteResource {
    
    
    @PersistenceContext(unitName = "com.mycompany_ProjetoRest_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @POST
    @Produces(MediaType.APPLICATION_XML)
    
    public Response salvar(@BeanParam Cliente cliente){
       em.persist(cliente);
       return Response.ok(cliente).build();
    }
    
    
}
