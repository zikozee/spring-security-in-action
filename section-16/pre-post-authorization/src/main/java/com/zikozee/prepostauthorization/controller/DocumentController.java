package com.zikozee.prepostauthorization.controller;

import com.zikozee.prepostauthorization.model.Document;
import com.zikozee.prepostauthorization.service.DocumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 21 Feb, 2022
 */

@RestController
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping(path = "documents/pre/{code}")
    public Document getDetailsPre(@PathVariable(value = "code") String code){
        return documentService.getDocumentPreAuthorize(code);
    }

    @GetMapping(path = "documents/{code}")
    public Document getDetails(@PathVariable(value = "code") String code){
        return documentService.getDocumentPostAuthorize(code);
    }
}
