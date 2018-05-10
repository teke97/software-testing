package domain;

public class Construction {
	public String name;
	public Location location;

	public Construction (String name) {
		this.name = name;
	}

	public void setLocation (Location location) {
		this.location = location;
	}

	public String getLocation(){
		return this.name + " " + this.location.spot + " " + this.location.relation.name;
	}
}