package org.example;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Person2 person2 = context.getBean("person2", Person2.class);
        person2.callYourPet();
        context.close();
    }
}
