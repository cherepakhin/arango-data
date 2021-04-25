package ru.perm.v.arangodata;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Slf4j
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArangoCtrl {

    RecommenOrderStvRepository recommenOrderStvRepository;

    @GET
    @Path("/echo/{mes}")
    public String echo(@PathParam("mes") String mes) {
        log.info("mes={}", mes);
        return mes;
    }

    @GET
    @Path("/recorder/{key}")
    public RecommendOrderStv recorder(@PathParam("key") String key) {
        return getRecommenOrderStvRepository().findById(key).orElse(new RecommendOrderStv());
    }

    public RecommenOrderStvRepository getRecommenOrderStvRepository() {
        return recommenOrderStvRepository;
    }

    public void setRecommenOrderStvRepository(RecommenOrderStvRepository recommenOrderStvRepository) {
        this.recommenOrderStvRepository = recommenOrderStvRepository;
    }
}
