package com.example.vao;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;


@Data
@NoArgsConstructor
@AllArgsConstructor
@MongoEntity(collection = "ads")
public class Ad extends ReactivePanacheMongoEntity{
    public ObjectId id;
    public Integer clicks;
    public String title;
    public String description;
}
