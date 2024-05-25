package com.api.Magic.Repository;

import com.api.Magic.Model.Entity.Card;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends MongoRepository<Card, ObjectId> {

    List<Card> findAllByType(String type);
}
