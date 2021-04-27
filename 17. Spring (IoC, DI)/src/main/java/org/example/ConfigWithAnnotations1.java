/**
 * Конфигурация с помощью аннотаций
 */
package org.example;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");
        Kitten myKitten = context.getBean("kittenBean", Kitten.class);
        myKitten.say();
        context.close();
    }
}
