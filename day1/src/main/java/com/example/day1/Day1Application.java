package com.example.day1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Day1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context
				= SpringApplication.run(Day1Application.class, args);

		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println(context.getBeanDefinitionCount());
	}

}
