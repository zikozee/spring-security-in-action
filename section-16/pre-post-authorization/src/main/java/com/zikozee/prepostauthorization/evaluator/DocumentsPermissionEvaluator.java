package com.zikozee.prepostauthorization.evaluator;

import com.zikozee.prepostauthorization.model.Document;
import com.zikozee.prepostauthorization.repo.DocumentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : Ezekiel Eromosei
 * @created : 21 Feb, 2022
 */

@Slf4j
@Component
public class DocumentsPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private DocumentRepository documentRepository;


    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {

        //manager or owner can receive result

        Document document = (Document) targetDomainObject;
        String p = (String) permission;

        log.info("PERMISSION: {}", authentication.getAuthorities());

        boolean manager = authentication.getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals(p));

        return manager || document.getOwner().equals(authentication.getName());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {

        //admin or owner can access

        String code = targetId.toString();

        Document document = documentRepository.findDocument(code);

        String p  = (String) permission;

        boolean admin = authentication.getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals(p));

        return LocalDateTime.now().isBefore(LocalDateTime.now().plusHours(2)) &&(admin || document.getOwner().equals(authentication.getName()));
    }
}
