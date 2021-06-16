package it.unimore.dipi.iot.demo.cdt.worker;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.errors.ErrorMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.unimore.dipi.iot.demo.cdt.dto.UpdateNdtRequest;
import it.unimore.dipi.iot.demo.cdt.model.ZoneDigitalTwinDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/api/ndt/")
@Api("NDT default API Endpoint")
public class NdtResource {

    final protected Logger logger = LoggerFactory.getLogger(NdtResource.class);

    public static class MissingKeyException extends Exception{}
    final NdtHttpServiceConfig conf;

    public NdtResource(NdtHttpServiceConfig conf) {
        this.conf = conf;
    }

    @GET
    @Path("/")
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Get Ndt Descriptor")
    public Response getNdt(@Context ContainerRequestContext req) {

        try {

            ZoneDigitalTwinDescriptor zoneDigitalTwinDescriptor = this.conf.getNdtDataManager().getZoneDescriptor();

            if(zoneDigitalTwinDescriptor == null)
                return Response.status(Response.Status.NOT_FOUND).type(MediaType.APPLICATION_JSON_TYPE).entity(new ErrorMessage(Response.Status.NOT_FOUND.getStatusCode(),"Resource Not Found !")).build();

            return Response.ok(zoneDigitalTwinDescriptor).build();

        } catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON_TYPE).entity(new ErrorMessage(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),"Internal Server Error !")).build();
        }
    }

    @PUT
    @Path("/")
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Update an existing resource")
    public Response updateDigitalTwin(@Context ContainerRequestContext req,
                                      @Context UriInfo uriInfo,
                                      UpdateNdtRequest updateNdtRequest) {

        try {

            logger.info("Incoming Edge Node ({}) Update Request: {}", updateNdtRequest);

            //Check if the request is valid and Path Id match resource id
            if(updateNdtRequest == null)
                return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON_TYPE).entity(new ErrorMessage(Response.Status.BAD_REQUEST.getStatusCode(),"Invalid request ! Check Resource Id")).build();

            this.conf.getNdtDataManager().updateZoneDescriptor(updateNdtRequest);

            return Response.noContent().build();

        } catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON_TYPE).entity(new ErrorMessage(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),"Internal Server Error !")).build();
        }
    }

}
