/**
 * Класс "Щенята"
 */
package org.example;

import org.springframework.stereotype.Component;

@Component
public class Puppy implements Pet {

    public Puppy(){
        System.out.println("Puppy bean is created");
    }

    @Override
    public void say() {
        System.out.println("aw-aw");
    }
}
