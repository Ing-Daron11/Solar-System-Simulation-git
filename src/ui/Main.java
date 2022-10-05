package ui; 

import java.util.Scanner;
import model.SolarSystem; 

public class Main{

	private Scanner reader; 
	private SolarSystem solarSystem; 

	public Main(){
		reader = new Scanner(System.in); 
		solarSystem = new SolarSystem(); 

	}
	public SolarSystem getSolarSystem(){
		return solarSystem; 
	}

	public Scanner getReader(){
		return reader;
	}

	public static void main(String[] args){
		// creación del objeto. 
		Main main = new Main();
		int option = 0; 

				do{

					option = main.getOptionShowMenu();
					main.executeOption(option);

				}while(option != 0);

				main.getReader().close();
	}
	
	public int getOptionShowMenu(){
		boolean isValid = false;
		String userInput = "";
		int option = 0; 
		System.out.println("<<<<< Welcome >>>>>");
		System.out.println(
				"1. Add Person\n" +
				"2. change person to another planet \n" +
				"3. list People \n" +
				"0. Exit. ");
		//Validación
		while(isValid == false){
					userInput = reader.next();
					try{
						option = Integer.parseInt(userInput);
						isValid = true;
						} catch(NumberFormatException e){
							System.out.println("Error, ingrese un número entero ");
						}
				} //fin de la validación.

		return option; 
	}

	public void executeOption(int option){
		String namePerson = ""; 
		int yearsPerson = 0; 
		String idPerson = ""; 
		String namePlanet = ""; 
		String msj = "";
		boolean isValid = false; //It is for validation
		int num = 0;
		String userInput = "";

		switch(option){
			case 1: 
			System.out.println("type the name of the planet you want to start with. ");
			namePlanet = reader.next(); 
			boolean isEmpty = solarSystem.callHasEmptyPos(namePlanet); 
			if(isEmpty){
				// petición de la información necesaria 
				System.out.println("type name person"); 
				namePerson = reader.next();
				//validación
				while(isValid == false){
					System.out.println("Type years: ");
					userInput = reader.next();
					try{
						yearsPerson = Integer.parseInt(userInput);
						isValid = true;
						} catch(NumberFormatException e){
							System.out.println("Error, ingrese un número entero");
						}
				}//fin de la validación
				
				System.out.println("Type Id"); 
				idPerson = reader.next(); 
				// llamado a la operación de agregar 
				msj = solarSystem.addPersonToPlanet(namePerson, yearsPerson, idPerson, namePlanet); 
				System.out.println(msj);
			} else{
				System.out.println("No se puede agregar a la persona"); 
			}

				break; 

			case 2: //change person
				System.out.println("Type the planet where the person is located");
				namePlanet = reader.next();
				System.out.println("type the id of the person you want to move to another planet");
				String personId = reader.next();
				System.out.println("Type the name of that person");
				namePerson = reader.next();
				//Validación
				while(isValid == false){
					System.out.println("type the years of that person");
					userInput = reader.next();
					try{
						yearsPerson = Integer.parseInt(userInput);
						isValid = true;
						} catch(NumberFormatException e){
							System.out.println("Error, ingrese un número entero");
						}
				}//fin de la validación
				System.out.println("Type the new planet you want to move " + namePerson);
				String newPlanetName = reader.next();
				msj = solarSystem.changePersonPlanet(namePlanet,personId,namePerson, yearsPerson, newPlanetName);
				System.out.println(msj);

				
				break; 

			case 3: //list persons
				msj = solarSystem.callListPersons();
				System.out.println(msj);
				
				break; 
				 
			case 0: 
				System.out.println("Exit program.");
				break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}



}
