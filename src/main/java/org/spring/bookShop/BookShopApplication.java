package org.spring.bookShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class BookShopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BookShopApplication.class, args);
		Environment env = context.getEnvironment();
		String port = env.getProperty("server.port");
		System.out.println("Server started on port " + port);
	}

}
