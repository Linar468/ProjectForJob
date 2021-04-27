package org.example.springAop.aop;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary {
    public void getBook() {
        System.out.println("Мы берем книгу из UniversityLibrary ");
        System.out.println("-----------------------------------");
    }
    public String returnBook(){
        //int a = 10/0;
        System.out.println("Мы возвращаем книгу в UniversityLibrary");
        System.out.println("-----------------------------------");
        return "1984";
    }

    public void addBook(String personName, Book book){
        System.out.println("Мы добавляем книгу в UniversityLibrary");
        System.out.println("---------------------------------------");
    }
    public void addMagazine(){
        System.out.println("Мы добавляем журнал в UniversityLibrary");
        System.out.println("---------------------------------------");
    }

    public void returnMagazine(){
        System.out.println("Мы возвращаем журнал в UniversityLibrary");
        System.out.println("---------------------------------------");
    }

    public void getMagazine(){
        System.out.println("Мы берём журнал из UniversityLibrary");
        System.out.println("---------------------------------------");
    }

}
