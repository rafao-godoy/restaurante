package br.com.comercio.springcomercio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"springcomercio"})
public class SpringComercioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringComercioApplication.class, args);
	}


}
