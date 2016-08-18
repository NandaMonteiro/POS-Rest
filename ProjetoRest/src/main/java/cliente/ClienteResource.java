/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import com.sun.org.glassfish.gmbal.ParameterNames;
import java.net.URI;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author nanda
 */
@Path("cliente")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_XML)
public class ClienteResource {

    @PersistenceContext(unitName = "com.mycompany_ProjetoRest_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @POST

    public Response salvar(@BeanParam Cliente cliente) {
        em.persist(cliente);
        return Response.ok(cliente).build();
    }

    @GET
    @Path("{clienteId}")
    public Response listarPorId(@PathParam("clienteId") int clienteId) {
        Cliente find = em.find(Cliente.class, clienteId);
        return Response.ok(find).build();
    }

    @POST
    public Response criarCliente(Cliente cliente, @Context UriInfo info) {
        em.persist(cliente);
        String id = String.valueOf(cliente.getId()); //transformando o id de inteiro para string pq vai precisar na url
        String url = info.getBaseUriBuilder() //.../api 
                .path(ClienteResource.class) //.../api/cliente
                .path(id) //.../api/cliente/1
                .toString();
        return Response.created(URI.create(url))
                .entity(cliente)
                .build();

    }

    @DELETE
    @Path("id")
    public Response deletar(Cliente cliente, int id) {
        return Response.ok(cliente).build();
    }

    @GET
    @Path("{clienteId}")
    public Response getCliente(@PathParam("{clienteId}") int clienteId) {
        Cliente find = em.find(Cliente.class, clienteId);
        return Response.ok(find).build();
    }

    @GET
    public Response listarTodosClientes() {
        List<Cliente> resultList = em.createQuery("SELECT c FROM Cliente c ", Cliente.class).getResultList();

        GenericEntity<List<Cliente>> retorn = new GenericEntity<List<Cliente>>(resultList) {
        };

        return Response.ok(retorn).build();
    }

}
