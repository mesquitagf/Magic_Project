package com.api.Magic.Repository;

import com.api.Magic.Model.Entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends MongoRepository<Card, String> {

    Page<Card> findAllByTypeIgnoreCase(String type, Pageable pageable);
}
