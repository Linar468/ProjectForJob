package org.example.springAop.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

    @Pointcut("execution(* add*(..))")
    public void allAddMethods(){}

    @Pointcut("execution(* org.example.springAop.aop.UniversityLibrary.*(..))")
    private void allMethodsFromUniLibrary() {
    }


    @Pointcut("execution(* org.example.springAop.aop.UniversityLibrary.get*())")
    private void allGetMethodsFromUniLibrary() {
    }

    @Pointcut("execution(* org.example.springAop.aop.UniversityLibrary.return*())")
    private void allReturnMethodsFromUniLibrary() {
    }

    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    private void allGetAndReturnMethodsFromUniLibrary() {
    }
}
