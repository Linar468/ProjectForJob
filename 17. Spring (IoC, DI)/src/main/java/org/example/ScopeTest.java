/**
 * Пример работы с аннотацией @Scope в классе Lion
 */
package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Lion lion = context.getBean("lion", Lion.class);
        Lion lion2 = context.getBean("lion", Lion.class);

        System.out.println("Один и тот же объект?" + " " +  (lion==lion2));
        System.out.println(lion);
        System.out.println(lion2);

        context.close();


    }
}
