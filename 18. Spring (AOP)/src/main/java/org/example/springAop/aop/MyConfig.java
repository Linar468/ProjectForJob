package org.example.springAop.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.example.springAop")
@EnableAspectJAutoProxy
public class MyConfig {
}
