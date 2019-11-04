package org.kostenko.example.batch;

import java.util.Properties;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author kostenko
 */
@Path("/batchdemo")
@Stateless
public class BatchDemoEndpoint {

    @GET
    @Path("/generate-jobs")
    public Response generateBatchJobs(@QueryParam("count") Integer count) {

        for (int i = 0; i < count; i++) {
            BatchRuntime.getJobOperator().start("empty", new Properties());
        }
        
        return Response.ok().entity(count + " batch jobs was generated").build();
    }

    @GET
    @Path("/collect-garbage")
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Response collectGarbage() {
        BatchRuntime.getJobOperator().start("garbageCollection", new Properties());
        return Response.ok().entity("Batch job garbage was collected").build();
    }

}
