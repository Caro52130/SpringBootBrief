package com.simplon.BriefSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.simplon.BriefSpring.View.ViewCustomers;


	@SpringBootApplication
	public class BriefSpringApplication implements CommandLineRunner {

	@Autowired
	private ViewCustomers vw;

	public static void main(String[] args) {
		SpringApplication.run(BriefSpringApplication.class, args);
	}
	
	public void run(String...args) throws Exception {
	//	vw.displayClients();
	}	
	
}
