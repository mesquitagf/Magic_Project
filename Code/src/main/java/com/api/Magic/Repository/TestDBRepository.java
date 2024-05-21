package com.api.Magic.Repository;

import com.api.Magic.Model.Entity.TestDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestDBRepository extends MongoRepository<TestDB, Integer> {
}
