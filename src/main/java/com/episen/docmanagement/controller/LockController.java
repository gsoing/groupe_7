package com.episen.docmanagement.controller;

import com.episen.docmanagement.entity.Lock;
import com.episen.docmanagement.service.LockService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DocumentController.PATH)
@AllArgsConstructor
@Slf4j
public class LockController {
    public static final String PATH = "/api/v1/documents";

    public LockService lockService;

    @PutMapping("/{documentId}/lock")
    @ResponseBody
    public ResponseEntity<Lock> createLock(@PathVariable(required = true) String documentId, @RequestBody Lock lock){
        Lock createdLock = lockService.createLock(documentId, lock);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdLock);
    }


    //TODO: Ajout gestion des erreurs
    //TODO: Si un document est verrouillé, personne à part le propriétaire du verrou ne peut le modifier. Seul le propriétaire d’un verrou peut déverrouiller un document.
    @GetMapping("/{documentId}/lock")
    @ResponseBody
    public ResponseEntity<Lock> getLock(@PathVariable(required = true) String documentId){
        Lock lock = lockService.getLock(documentId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lock);
    }

    @DeleteMapping("/{documentId}/lock")
    @ResponseBody
    public ResponseEntity<Lock> deleteLock(@PathVariable(required = true) String documentId){
        Lock lock = lockService.deleteLock(documentId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lock);
    }

}
