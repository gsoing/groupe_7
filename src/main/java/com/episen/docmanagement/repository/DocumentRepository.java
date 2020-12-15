package com.episen.docmanagement.repository;

import com.episen.docmanagement.entity.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<Document, String> {

}
