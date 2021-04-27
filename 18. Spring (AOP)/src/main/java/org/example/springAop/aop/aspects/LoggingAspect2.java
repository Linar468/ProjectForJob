package org.example.springAop.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect2 {
    /*@Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");
        Object targetMEthodResult = null;
        try {
            targetMEthodResult = proceedingJoinPoint.proceed();
        }
        catch (Exception e){
            System.out.println("aroundReturnBookLoggingAdvice: было поймано исключение " + e);
            targetMEthodResult = "Неизвестное название книги";
        }
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
        return targetMEthodResult;

    }*/

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");
        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice: было поймано исключение " + e);
            throw e;
        }
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
        return targetMethodResult;
    }
}
