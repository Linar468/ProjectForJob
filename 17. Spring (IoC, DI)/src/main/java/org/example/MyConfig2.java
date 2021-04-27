/**
 * Конфигурация бинов аннотацией @Bean
 */
package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("myApp.properties")
public class MyConfig2 {

    @Bean
    public Pet puppyBean(){
        return new Puppy();
    }


    @Bean
    public Pet catBean(){
        return new Cat();
    }

    @Bean
    public Person3 person3Bean(){
        return new Person3(catBean());
    }

    @Bean
    public Person2 person2Bean(){
        return new Person2(catBean());
    }
}
