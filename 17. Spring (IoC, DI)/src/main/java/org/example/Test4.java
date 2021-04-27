/**
 * Использование scope "prototype"
 */
package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        Cat myCat = context.getBean("myCat", Cat.class);
        Cat yourCat = context.getBean("myCat", Cat.class);

        myCat.setName("katy");
        yourCat.setName("Tom");

        System.out.println(myCat.getName());
        System.out.println(yourCat.getName());
        System.out.println(myCat);
        System.out.println(yourCat);
        context.close();


    }
}
