package org.example.springAop.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class SecurityAspect {
    @Before("org.example.springAop.aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddSecurityAdvice(){
        System.out.println("beforeGetSecurityAdvice: проверка прав на получение книги/журнала");
        System.out.println("----------------------------------");

    }
}
