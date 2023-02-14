package com.simplon.BriefSpring.repository;

import java.util.ArrayList;

import java.util.Scanner;

import com.simplon.BriefSpring.model.Customer;

public class Data {
	public static ArrayList<Customer> listClient = new ArrayList<Customer>();
	
	 public static ArrayList <Customer> getData() {
		Customer client1= new Customer ("Julien", "123456", "1 Porte d'Arras", "31000", "Toulouse");
		Customer client2= new Customer ("Caroline", "345678", "Cormontaigne", "59000", "Lille");
		listClient.add(client1);
		listClient.add(client2);
		return listClient;
	 }
	 
	 public static ArrayList<Customer> addData() {
		 Scanner scn= new Scanner (System.in);
		 System.out.println("Entrez le nom:");
		 String name= scn.nextLine();
		 
		 System.out.println("Entrez le numéro de SIRET:");
		 String siret= scn.nextLine();
		 
		 System.out.println("Entrez l'adresse:");
		 String address= scn.nextLine();
		 
		 System.out.println("Entrez le code postal:");
		 String postalCode= scn.nextLine();
		 
		 System.out.println("Entrez la ville:");
		 String city= scn.nextLine();
		 
		 Customer clientSupp= new Customer(name, siret, address, postalCode, city);
		 listClient.add(clientSupp);
		 return listClient;
	 }
	 
	 public static ArrayList<Customer> removeData(){
		 Scanner scn2= new Scanner (System.in);
		 System.out.println("Entrez le nom à supprimer:");
		 String name= scn2.nextLine();
		 
		 for (int i=0; i<listClient.size(); i++) {
			 String nameCustomer = listClient.get(i).getName();
			 if (name.equals(nameCustomer)) {
				 listClient.remove(i);
				 break;
			 }
		 }		 
		 return listClient;
	 }
}
