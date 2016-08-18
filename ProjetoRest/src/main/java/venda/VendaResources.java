/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda;

//import javax.scene.media.Media;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author kaiqu
 */
@Path("venda")
@Stateless
public class VendaResources {

    @PersistenceContext
    private EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Path("{vendaId}/produto/{produtoId}")
    public Response addProduto(
            @PathParam("vendaId") int vendaId,
            @PathParam("produtoId") int produtoId) {
        Venda venda = new ServiceVenda().addProduto(vendaId, produtoId);
        return Response.ok(venda).build();
    }

}
