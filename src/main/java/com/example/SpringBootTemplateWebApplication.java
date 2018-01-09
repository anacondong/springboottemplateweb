package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author Ittipol
 *
 */
//@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootTemplateWebApplication {
	
	// Home Page
	// http://localhost:8081/springBootTemplateWeb/
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTemplateWebApplication.class, args);
	}
	
//	 @Bean
//	    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//	        return args -> {
//
//	            System.out.println("Let's inspect the beans provided by Spring Boot:");
//	            String[] beanNames = ctx.getBeanDefinitionNames();
//	            Arrays.sort(beanNames);
//	            for (String beanName : beanNames) {
//	                System.out.println(beanName);
//	            }
//	        };
//	    }
	
	
	
	
}




