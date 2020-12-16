package com.episen.docmanagement.service;


import com.episen.docmanagement.entity.Lock;
import com.episen.docmanagement.repository.LockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LockService {
    @Autowired
    public final LockRepository lockRepository;

    public DocumentService documentService;

    public Lock createLock(String documentId, Lock lock){
        Lock newLock = new Lock(documentId, lock.getOwner(), lock.getCreated());
        Lock insertedUser = lockRepository.insert(newLock);
        return insertedUser;
    }

    public List<Lock> findAll(){
        return this.lockRepository.findAll();
    }

    public Lock getLock(String documentId){
        for (Lock l: findAll()){
            if (l.getDocumentId().equals(documentId))
                return l;
        }
        return null;
    }

    public Lock deleteLock(String documentId) {
        Lock lock = getLock(documentId);
        this.lockRepository.delete(lock);
        return null;
    }
}
