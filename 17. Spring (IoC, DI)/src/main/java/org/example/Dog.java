/**
 * Класс "Собака"
 * Определение бинов в файле applicationContext.xml
 */
package org.example;

public class Dog implements Pet {
    public Dog(){
        System.out.println("Dog bean is created");
    }

    @Override
    public void say() {
        System.out.println("BOW-WOW");
    }

    public void init(){
        System.out.println("Class Dog: Initialization");
    }

    public void destroy(){
        System.out.println("Class Dog: Destroying");
    }
}
