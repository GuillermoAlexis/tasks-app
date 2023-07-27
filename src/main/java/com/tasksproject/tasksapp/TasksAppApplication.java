package com.tasksproject.tasksapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tasksproject.tasksapp") // Asegura el escaneo de componentes en este paquete y
															// subpaquetes
public class TasksAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksAppApplication.class, args);
	}
}
