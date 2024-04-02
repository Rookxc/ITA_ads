package com.example.rest;

import com.example.jms.consumer.ClicksConsumer;
import com.example.vao.Ad;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import com.example.dao.AdRepository;

import java.util.List;
import java.util.stream.Collectors;


@Path("/ad")
public class AdResource {
    @Inject
    AdRepository adRepository;

    @Inject
    ClicksConsumer consumer;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<Ad> createAd(Ad ad) {
        ad.setClicks(consumer.getClicks());
        return adRepository.addAd(ad);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<String>> getAllGreetings() {
        return adRepository.listAllAds()
                .onItem().transform(ads -> ads.stream()
                        .map(ad -> ad.title)
                        .collect(Collectors.toList()));
    }
}
