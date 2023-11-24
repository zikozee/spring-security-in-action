package com.zikozee.prepostauthorization.service;

/**
 * @author : Ezekiel Eromosei
 * @created : 21 Feb, 2022
 */

import com.zikozee.prepostauthorization.model.Document;
import com.zikozee.prepostauthorization.repo.DocumentRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }


    @PreAuthorize("hasPermission(#code, 'document', 'ROLE_admin')")
    public Document getDocumentPreAuthorize(String code){
        return documentRepository.findDocument(code);
    }

    @PreAuthorize("@demoConditionEvaluator.evaluateMe(#code)")
    public Document getDocumentPreAuthorize2(String code){
        return documentRepository.findDocument(code);
    }

    @PostAuthorize("hasPermission(returnObject, 'ROLE_manager')")
    public Document getDocumentPostAuthorize(String code){
        return documentRepository.findDocument(code);
    }
}
