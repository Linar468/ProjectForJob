/**
 * Класс "Котёнок"
 * Использование аннотации Component
 */
package org.example;

import org.springframework.stereotype.Component;

@Component("kittenBean")
public class Kitten implements Pet {
    public Kitten(){
        System.out.println("Kitten bean is created");
    }
    @Override
    public void say() {
        System.out.println("meoooow-weow");
    }
}
