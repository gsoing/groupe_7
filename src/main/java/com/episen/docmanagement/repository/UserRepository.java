package com.episen.docmanagement.repository;

import com.episen.docmanagement.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
