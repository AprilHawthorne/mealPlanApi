package com.promineotech.mealPlanApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.promineotech.mealPlanApi.Application;

@ComponentScan("com.promineotech.mealPlanApi")
@SpringBootApplication
public class Application 
{
		public static void main( String[] args)
		{
			SpringApplication.run(Application.class, args);
		}

	}
