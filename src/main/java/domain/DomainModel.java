package domain;

public class DomainModel {

	public static void main (String args []) {
		Construction building = new Construction("Building");
		Construction window = new Construction("Window");
		Construction platform = new Construction("Platform");

		building.setLocation(new Location("behind", platform));
		window.setLocation(new Location("in", building));
		platform.setLocation(new Location("in front of", building)); 

		Person arthur = new Person("Arthur");

		arthur.slide();
	}	

}
