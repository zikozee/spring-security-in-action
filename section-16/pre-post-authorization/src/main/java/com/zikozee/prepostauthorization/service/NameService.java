package com.zikozee.prepostauthorization.service;

/**
 * @author : Ezekiel Eromosei
 * @created : 21 Feb, 2022
 */

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NameService {

    private static final Map<String, List<String>> secretNames=
            Map.of("natalie", List.of("Energico", "Fantastico"), "emma", List.of("Fantastico"));

    @PreAuthorize("hasAuthority('write')")
    public String getName(){
        return "Fantastico";
    }

    @PreAuthorize("#name == authentication.principal.username")
    public List<String> getSecretNames(String name){
        return secretNames.get(name);
    }
}
