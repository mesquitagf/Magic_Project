package com.api.Magic.Repository;

import com.api.Magic.Model.Entity.ManaType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManaTypeRepository extends MongoRepository<ManaType, String> {
}
