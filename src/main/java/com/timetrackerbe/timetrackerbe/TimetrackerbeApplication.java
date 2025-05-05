package com.timetrackerbe.timetrackerbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class TimetrackerbeApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();
		System.setProperty("MONGO_URI", dotenv.get("MONGO_URI"));
		System.setProperty("SERVER_PORT", dotenv.get("SERVER_PORT"));

		SpringApplication.run(TimetrackerbeApplication.class, args);
	}

}
