package com.api.Magic.Repository;

import com.api.Magic.Model.Entity.Card;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardRepository extends MongoRepository<Card, ObjectId> {
}
