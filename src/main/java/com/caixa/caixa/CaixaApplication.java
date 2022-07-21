package com.caixa.caixa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@SpringBootApplication
public class CaixaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaixaApplication.class, args);
	}

}
