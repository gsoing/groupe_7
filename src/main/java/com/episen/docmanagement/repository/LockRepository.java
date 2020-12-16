package com.episen.docmanagement.repository;

import com.episen.docmanagement.entity.Lock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LockRepository extends MongoRepository<Lock, String> {
}
