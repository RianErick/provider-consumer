package org.example.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.model.Produtor;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.Optional;

@Path(value = "produtor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutorResource {

    @Inject
    org.example.service.ProdutorService produtorService;

    @POST
    @Transactional
    public RestResponse<Produtor> pesisterIt(Produtor produtor) {
        produtorService.insertAt(produtor);
        return RestResponse.status(Response.Status.CREATED, produtor);
    }

    @GET
    @Path("/{id}")
    public RestResponse<Produtor> getProdutorById(@PathParam(value = "id") Long id) {
        Produtor produtor = produtorService.findById(id);
        return RestResponse.ok(produtor);
    }
}
