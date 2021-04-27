/**
 * Класс "Лев"
 * Конфигурация с помощью аннотаций
 */
package org.example;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class Lion implements Pet {
    private String name;

    public Lion(){
        System.out.println("Lion bean is created");
    }
    @Override
    public void say() {
        System.out.println("ROOAAARRRRR...");
    }
    @PostConstruct
    public void init(){
        System.out.println("Class Lion: Initialization");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Class Lion: Destroying");
    }
}
