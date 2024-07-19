package br.com.danilooa.ocpjadee7.webservices.rs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/RsExample")
public class RsExample {

    @GET
    @Path("/firstGet")
    public Response getString() {
        return Response.ok().build();
    }

}
