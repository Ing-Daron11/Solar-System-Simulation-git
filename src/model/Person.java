package model; 


public class Person{
	
	private String name; 
	private int years; 
	private String id; 
	private String typeOfPerson;

	//Contructor
	public Person(String aname, int ayears, String aid){
		name = aname; 
		years = ayears; 
		id = aid; 
		typeOfPerson(years);
	}
	
	/**This method allows assigning a range of time according to the years of life.
	 * @param: years: int = It contains the years old of the person.
	 * @return: typeOfPerson: String = It has the message with the time according to the years.
	 */
	public String typeOfPerson(int years){
		if(years <0){
			typeOfPerson = "Invalid number.";
		}else if(years >=0 && years <=14){
			typeOfPerson = "You´re infantil";
		}else if(years >=15 && years <= 17){
			typeOfPerson = "You´re teenager";
		}else if(years >=18 && years <=60){
			typeOfPerson = "You´re adult ";
		}else{
			typeOfPerson = "You´re Elderly";
		}
		return typeOfPerson;
	}

	//Geters and seters
	public String getName(){
		return name; 
	}

	public void setName(String aname){
		name = aname; 
	}

	public int getYears(){
		return years; 
	}


	public String getId(){
		return id; 
	}
}
