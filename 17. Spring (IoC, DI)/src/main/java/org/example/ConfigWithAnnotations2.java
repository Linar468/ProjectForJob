/**
 * Конфигурация с помощью аннотаций
 */
package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Person2 person2 = context.getBean("person2", Person2.class);
        person2.callYourPet();

        System.out.println(person2.getSurname());
        System.out.println(person2.getAge());
        context.close();
    }
}
