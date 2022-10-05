package model; 

public class SolarSystem{

	public static final int SOLAR_SYSTEM_SIZE = 8;


	private Planet[] planets;
	private Person person; 

	public SolarSystem() {
		planets = new Planet[SOLAR_SYSTEM_SIZE]; 
		planets[0]=new Planet("Mercurio",0,0.4,88);
		planets[1]=new Planet("Venus",0,0.7,225);
		planets[2]=new Planet("Tierra",1,1,365.25);
		planets[3]=new Planet("Marte",2,1.5,1.88);
		planets[4]=new Planet("Jupiter",79,5.2,11.86);
		planets[5]=new Planet("Saturno",62,9.5,29.45);
		planets[6]=new Planet("Urano",27,19.8,84);
		planets[7]=new Planet("Neptuno",14,30.1,164.81);
	}

	public Planet[] getPlanets(){
		return planets; 
	}

	/** This method allows to add a person to a previously searched planet by creating the object "Person" calling the method "addPersonWithObject" from the class Person.
	 * @param: namePerson: String = It's the name of the person
	 * @param: yearsPerson: int = It's the years old of the person.
	 * @param: personId: String = It's the ID of the person.
	 * @param: namePlanet: String = It's the planet where is going to be added the person.
	 * @return: msj: String = It contains the message if the person was successfully added or not.
	 */
	public String addPersonToPlanet(String namePerson, int yearsPerson, String personId, String namePlanet){
		String msj = "No se pudo agregar una person"; 
		Person newPerson = new Person(namePerson, yearsPerson, personId); 
		int posPlanet = searchPlanetByName(namePlanet); 
		if(posPlanet != -1 ){
			msj = planets[posPlanet].addPersonWithObject(newPerson); 
		}
		return msj; 
	}

	/** This method uses the method "searchPlanetByName" to locate a planet, and then calls "hasEmptyPos" from the class Planet to check if there's space available in the planet.
	 * @param: namePlanet: String = It is the planet that is going to be checked for space.
	 * @return: isEmpty: boolean = It contains "True" if there´s space or "False" if not.
	 */
	public boolean callHasEmptyPos(String namePlanet){
		boolean isEmpty = false; 
		int posPlanet = searchPlanetByName(namePlanet); 
		if(posPlanet != -1){ // ! = 
			isEmpty = planets[posPlanet].hasEmptyPos(); 
		}
		return isEmpty; 
	}

	/**This method allows to look for a planet in the array by its name.
	 * @param: planetName: String = It's the planet that is going to be searched.
	 * @return: isFound: It returns "True" if was found or "False" if not.
	 */
	public int searchPlanetByName(String planetName){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SOLAR_SYSTEM_SIZE && !isFound; i++ ){
			if(planets[i].getName().equalsIgnoreCase(planetName)){
				pos = i; 
				isFound = true; 
			}
		}
		return pos; 
	}

	/**This method allows to change a person from one planet to another planet, and then delete that person from the past planet.
	 * @param: namePlanet: String = It represents the currently planet where the person is located.
	 * @param: personId: String = It's the ID of the person.
	 * @param: namePerson: String = It's the name of the person.
	 * @param: yearsPerson: int = It's the years old of the person.
	 * @param: newPlanet: String = It represents the new planet where the person wants to travel.
	 * @return: msj: String = It contains a message that says whether the person was successfully moved or was not possible.
	 */
	public String changePersonPlanet(String namePlanet, String personId, String namePerson, int yearsPerson, String newPlanet){
	String msj = "";
	boolean isEmpty = callHasEmptyPos(newPlanet);
	if (isEmpty){
		int posPlanet = searchPlanetByName(namePlanet);
		msj = addPersonToPlanet(namePerson, yearsPerson, personId, newPlanet) + " in the planet: " + newPlanet;
		String personDeleted = planets[posPlanet].deletePerson(personId); //here, the person is already being searched and it is eliminated from where it is found
	} else{
		msj = "It was not possible to move the person, since there is no space in the planet or the planet does not exist";
	}
		return msj;		
	}

	/**This method calls the method "listPersons" from the class Planet, and receive the list of the people of a planet,
	 * then this method do the same for each planet in the SolarSystem.
	 * @param: None 
	 * @return: msj: String = It contains the list and the information from every person in all planets.
	 */
	public String callListPersons(){
		String msj = "";
		for(int i = 0; i < SOLAR_SYSTEM_SIZE; i++){
			msj += planets[i].listPersons();
		}
		return msj;
	}
}
