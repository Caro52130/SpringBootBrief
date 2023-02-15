package com.simplon.BriefSpring.controler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simplon.BriefSpring.model.Customer;
import com.simplon.BriefSpring.repository.DataRepository;

import java.util.List;
import java.util.Scanner;

@Component
public class DataController {
	 @Autowired
	    DataRepository dataRespository;

	    public List<Customer> index(){
	        return dataRespository.findAll();
	    }

	    public Customer create(){
	    	Scanner scn= new Scanner (System.in);
			 System.out.println("Entrez le nom:");
			 String name= scn.nextLine();
			 
			 System.out.println("Entrez le numéro de SIRET:");
			 String siret= scn.nextLine();
			 
			 System.out.println("Entrez l'adresse:");
			 String address= scn.nextLine();
			 
			 System.out.println("Entrez le code postal:");
			 String postal_code= scn.nextLine();
			 
			 System.out.println("Entrez la ville:");
			 String city= scn.nextLine();
			 
	        return dataRespository.save(new Customer(name, siret, address, postal_code, city));
	    }

//	    public Customer update(@PathVariable String id, @RequestBody Map<String, String> body){
//	        int dataId = Integer.parseInt(id);
//	        // getting blog
//	        Optional<Customer> data = dataRespository.findById(dataId);
//	        data.setName(body.get("name"));
//	        data.setSiret(body.get("content"));
//	        return dataRespository.save(data);
//	    }

	    public boolean delete(){
	    	Scanner scn2= new Scanner (System.in);
			 System.out.println("Entrez l'id à supprimer:");
			 int dataId = scn2.nextInt();
	        dataRespository.deleteById(dataId);
	        return true;
	    }

	}
	


