package org.renci.opm.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.renci.opm.dao.model.Invalidation;

@Path("/InvalidationService/")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public interface InvalidationService {

    @GET
    @Path("/findById/{id}")
    public Invalidation findById(@PathParam("id") Long id);

    @POST
    @Path("/")
    public Long save(Invalidation invalidation);

}
