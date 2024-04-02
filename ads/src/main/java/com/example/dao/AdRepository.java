package com.example.dao;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import com.example.vao.Ad;
import org.bson.types.ObjectId;

import java.util.List;

@ApplicationScoped
public class AdRepository implements  ReactivePanacheMongoRepository<Ad>{
    public Uni<Ad> addAd(Ad ad) {
        ad.setId(new ObjectId());
        return persist(ad);
    }

    public Uni<List<Ad>> listAllAds() {
        return findAll().list();
    }

}
