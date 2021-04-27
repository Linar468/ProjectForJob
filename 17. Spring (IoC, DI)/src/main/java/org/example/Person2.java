/**
 * Использование @Autowired для внедрения зависимостей
 */
package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person2 {
    //@Autowired
    //@Qualifier("puppy")
    private Pet pet;
    private String surname;
    private int age;

    public Person2(){
        System.out.println("Person2 bean is created");
    }

    @Autowired
    public Person2(@Qualifier ("catBean") Pet pet){
        System.out.println("Person2 bean is created");
        this.pet = pet;
    }

    //@Autowired
    //@Qualifier("kittenBean")
    public void setPet(Pet pet) {
        System.out.println("Class Person2: set Pet");
        this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hello my pet");
        pet.say();
    }

    public String getSurname() {
        return surname;
    }

    @Value("${person.surname}")
    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    @Value("${person.age}")
    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }
}
