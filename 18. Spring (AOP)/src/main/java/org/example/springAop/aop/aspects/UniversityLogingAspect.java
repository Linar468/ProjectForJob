package org.example.springAop.aop.aspects;

import org.aspectj.lang.annotation.*;
import org.example.springAop.aop.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLogingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentLoggingAdvice(){
        System.out.println("beforeGetStudentLoggingAdvice: логируем получение " +
                "списка студентов перед методом getStudents");
    }


    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
    public void afterReturningGetStudentLoggingAdvice(List<Student> students){
        Student firstStudent = students.get(0);
        String nameSurname = firstStudent.getNameSurname();
        nameSurname = "Mr. " + nameSurname;
        firstStudent.setNameSurname(nameSurname);
        double avgGrade = firstStudent.getAvgGrade();
        avgGrade = avgGrade -5;
        firstStudent.setAvgGrade(avgGrade);
        System.out.println("afterReturningGetStudentLoggingAdvice: логируем получение " +
                "списка студентов после работы метода getStudents");
    }


   @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception){
        System.out.println("afterThrowingGetStudentLoggingAdvice: логгируем выброс исключения" + exception);
    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(){
        System.out.println("afterStudentsGetLoggingAdvice: логгируем нормальное окончание работы метода " +
                "или выброс исключения");
    }



}
