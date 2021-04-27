package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person3 {

    private Pet pet;
    private String surname;


    public Person3(@Qualifier("lion") Pet pet){
        System.out.println("Person3 bean is created");
        this.pet = pet;
    }


    public void callYourPet(){
        System.out.println("Hello my pet");
        pet.say();
    }





}
