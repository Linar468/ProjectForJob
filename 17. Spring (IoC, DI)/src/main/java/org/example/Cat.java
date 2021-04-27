/**
 * Класс "Кошка"
 */
package org.example;
public class Cat implements Pet {
    private String name;

    public Cat(){
        System.out.println("Cat bean is created");
    }
    @Override
    public void say() {
        System.out.println("MEOW");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void init(){
        System.out.println("Class Cat: Initialization");
    }

    public void destroy(){
        System.out.println("Class Cat: Destroying");
    }


}
