package model; 


public class Planet{

	public static final int SIZE_OF_PERSONS = 10;


	private String name; 
	private int sattelites; 
	private double au; 
	private double lengthOfYears; 

	private Person[] persons;

	//Constructor
	public Planet(String aname, int asattelites, double aau, double alengthOfYears){
		name = aname; 
		sattelites = asattelites; 
		au = aau; 
		lengthOfYears = alengthOfYears; 
		persons = new Person[SIZE_OF_PERSONS]; 

	}

	/** This method allows to return the private attribute of the name of the planet.
	 * @param: None
	 * @return: name: String = It contains the name of the planet.
	 */
	public String getName(){
		return name; 
	}


	public String addPerson(String name, int years, String id){
		// creo el objeto persona 
		Person newPerson = new Person(name, years, id); 
		String msj = "Capacidad máxima alcanzada."; 
		boolean isEmpty = false; 
		for(int i = 0; i <SIZE_OF_PERSONS && !isEmpty; i++){
			if(persons[i] == null){
				// agrego la persona al primer espacio disponible del arreglo 
				persons[i] = newPerson; 
				isEmpty = true; 
				msj = "Nuevo visitante agregado"; 
			}
		}

		return msj; 
	}

	/** This method allows to check if there is space in a planet.
	 * @param: None
	 * @return: isEmpty: boolean = It returns "True" if there's space or "False" if not.
	 */
	public boolean hasEmptyPos(){
		boolean isEmpty = false; 
		for(int i = 0; i < SIZE_OF_PERSONS && !isEmpty; i++){
			if(persons[i] == null){
				isEmpty = true; 
			}
		}
		return isEmpty; 
	}

	/** This method allows to add a person to the array by using the object already created.
	 * @param: person: Person = It's the object "person" already created.
	 * @return: msj: String = It contains the message if it was successfully added or if there wasn't space to added.
	 */
	public String addPersonWithObject(Person person){

		String msj = "Capacidad máxima alcanzada."; 
		boolean isEmpty = false; 
		for(int i = 0; i <SIZE_OF_PERSONS && !isEmpty; i++){
			if(persons[i] == null){
				// agrego la persona al primer espacio disponible del arreglo 
				persons[i] = person; 
				isEmpty = true; 
				msj = "Nuevo visitante agregado"; 
			}
		}

		return msj; 
	}

	public int countPersons(){
		int count = 0; 
		for(int i = 0; i < SIZE_OF_PERSONS; i++){
			if(persons[i] != null){
				count++; 
			}
		}
		return count;
	}


	public String deletePerson(String personId){
		String msj = "No se encontro la persona a eliminar"; 
		int pos = searchPersonById(personId); 
		if(pos != -1){
			persons[pos] = null; 
			msj = "la persona ha sido eliminada"; 
		}
		return msj; 
	} 

	public int searchPersonById(String personId){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE_OF_PERSONS && !isFound; i++){
			if(persons[i].getId().equals(personId)){
				pos = i; 
				isFound = true; 
			}
		}
		return pos; 
	}


	/**This method allows to list the people in a planet
	 * @param: None
	 * @return: msj: String = It contains the list with all the people in a planet
	 */
	public String listPersons(){
		String msj = "";
		for (int i = 0; i < SIZE_OF_PERSONS ; i++){
			if (persons[i] != null){
				msj += ("nombre: " + persons[i].getName() + ", 	Id: " + persons[i].getId() + " " + "	Ubicación: " + getName()) + "\n";
			}
		}
		return msj;
	}
}