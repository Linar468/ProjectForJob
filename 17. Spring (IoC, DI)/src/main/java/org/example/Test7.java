/**
 * Генерация объектов с помощью @Bean из класса MyConfig2.java
 */
package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test7 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);

        Pet puppy = context.getBean("puppyBean", Pet.class);
        puppy.say();

        Person3 person3 = context.getBean("person3Bean", Person3.class);
        person3.callYourPet();

        Person2 person2 = context.getBean("person2Bean", Person2.class);
        System.out.println(person2.getAge());
        System.out.println(person2.getSurname() );

        context.close();
    }
}
