package com.zikozee.prepostauthorization.evaluator;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


//another way to refactoring complex Preauthorize authentication logic to a separate class
@Component
public class DemoConditionEvaluator {

    public boolean evaluateMe(String code){
        var a = SecurityContextHolder.getContext().getAuthentication();
        return a.getName().equalsIgnoreCase(code); // dummy
    }
}
