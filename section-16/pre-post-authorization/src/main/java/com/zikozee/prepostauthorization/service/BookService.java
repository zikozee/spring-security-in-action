package com.zikozee.prepostauthorization.service;

/**
 * @author : Ezekiel Eromosei
 * @created : 21 Feb, 2022
 */

import com.zikozee.prepostauthorization.model.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private final Map<String, Employee> records =
            Map.of("emma",
                    Employee.builder().name("Emma Thompson")
                            .books(List.of("Karamazov Brothers"))
                            .roles(List.of("accountant", "reader")).build(),
                    "natalie",
                    new Employee("Natalie Parker",
                            List.of("Beautiful Paris"),
                            List.of("researcher"))
            );


    @PostAuthorize("returnObject.roles.contains('reader')")
    public Employee getBookDetails(String name){
        return records.get(name);
    }
}
