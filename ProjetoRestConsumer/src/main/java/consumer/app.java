/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

/**
 *
 * @author nanda
 */
public class app {
    
    public static void main(String[] args) {
        
        String uri = "http://localhost:8080/ProjetoRest/api";
        
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(uri);
        
//        Produto p = new Produto();
//        
//        Form form = new Form();
//        form.param("valor", "13.4");
//        form.param("descricao", "produto a");
//        
        
        Cliente cliente = new Cliente();
        Form form = new Form();
        form.param("nome", "Luciana" );
        
        

//        Response post = webTarget.path("produto")
//                .request()
//                .post(Entity.form(form));
//        Response post = webTarget.path("cliente");

        Response delete = webTarget.path("produto")
                .request()
                .delete();

        
        System.out.println("enviou requisicao");
        

        System.out.println(delete.readEntity(String.class));

//        System.out.println(post.readEntity(String.class));
 
    }
    
}
