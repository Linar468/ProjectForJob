package org.example.springAop.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.springAop.aop.Book;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

    @Before("org.example.springAop.aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("MethodSignature= " + methodSignature);
        System.out.println("MethodSignature.getMethod = " + methodSignature.getMethod());
        System.out.println("MethodSignature.getReturnType = " + methodSignature.getReturnType());
        System.out.println("MethodSignature.getName = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")){
            Object[] arguments = joinPoint.getArgs();
            for(Object obj : arguments){
                if(obj instanceof Book){
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: название - " + myBook.getName()
                            + " автор - " + myBook.getAuthor() + " год публикации - "
                            + myBook.getYearOfPublication());
                }
                else if (obj instanceof String){
                    System.out.println("Книгу добавляет " + obj);
                }

            }
        }
        System.out.println("beforeGetLoggingAdvice: попытка получить книгу/журнал");
        System.out.println("----------------------------------");
    }




}
