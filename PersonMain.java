package com.ty_one_to_one_uni1.controller;

import java.util.Scanner;

import com.ty_one_to_one_uni.dao.PancardDao;
import com.ty_one_to_one_uni.dao.PersonDao;
import com.ty_one_to_one_uni1.dto.Pancard;
import com.ty_one_to_one_uni1.dto.Person;

public class PersonMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Person person = new Person();
		Pancard pancard = new Pancard();
		PersonDao pdao = new PersonDao();
		PancardDao pcdao = new PancardDao();
		boolean exit = true;
		do {
			System.out.println("Enter Your Choice \n 1.Save \n 2.Update \n 3.Delete \n 4.Get By Id \n 5.Get All");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter Person Id");
				int id = scanner.nextInt();
				System.out.println("Enter Person Name");
				String name = scanner.next();
				System.err.println("Enter Person Phone");
				long phone = scanner.nextLong();
				System.out.println("Enter Person Address");
				String address = scanner.next();

				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				person.setPancard(pancard);

				System.out.println("Enter Pan Id");
				int id1 = scanner.nextInt();
				System.out.println("Enter Pan Name");
				String name1 = scanner.next();
				System.out.println("Enter Pan Address");
				String address1 = scanner.next();

				pancard.setName(name1);
				pancard.setAddress(address1);
				pancard.setPid(id1);

				pcdao.savePancard(pancard);
				pdao.savePerson(person);

			}
				break;// case 1 end
			case 2: {
				System.out.println("Enter Person Id to update");
				int id = scanner.nextInt();
				System.out.println("Enter Person Name to be update");
				String name = scanner.next();
				System.err.println("Enter Person Phone to be upadate");
				long phone = scanner.nextLong();
				System.out.println("Enter Person Address to be updated");
				String address = scanner.next();

				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				person.setPancard(pancard);

				System.out.println("Enter Pan Id");
				int id1 = scanner.nextInt();
				System.out.println("Enter Pan Name to be updated");
				String name1 = scanner.next();
				System.out.println("Enter Pan Address to be updated");
				String address1 = scanner.next();

				pancard.setName(name1);
				pancard.setAddress(address1);
				pancard.setPid(id1);

				pdao.updatePerson(person);
				pcdao.updatePancard(pancard);
			}
				break; //case 2 end
				
			case 3:{
				System.out.println("Enter a Person Id to be deleted");
				int id1 = scanner.nextInt();
				System.out.println("Enter a Pancard Id to be deleted");
				int id2 = scanner.nextInt();
				person.setId(id1);
				pancard.setPid(id2);
				pdao.deletePerson(person, id1);
				pcdao.deletePancard(pancard, id2);
				
			}break;// case 3 end
			case 4:{
				System.out.println("Enter a Person Id ");
				int id1 = scanner.nextInt();
				person.setId(id1);
				pdao.getAllPersonById(person, id1);
				
				System.out.println("Enter a Pancard Id ");
				int id2 = scanner.nextInt();
				pcdao.getAllPancardById(pancard, id2);
				pancard.setPid(id2);
			}break;
			case 5:{
				pdao.getAllPerson();
				pcdao.getAllPancard();
			}break;
			default : exit = false;
			
			}// switch end
		} while (exit);// do while

	}// main

}// class
