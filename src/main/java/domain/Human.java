package domain;

public class Human {

	public String state;
	public Location location;
	private boolean isOne;

	public Human(boolean isOne){
		this.isOne = isOne;
	}

	public void scream() {
		if(!isOne)
			this.state = States.MILLING.toString();
	}

	public void oratory() {
		if(isOne)
			this.state = States.ORATORYING.toString();
	}

	public void setLocation(Location location) {
		if (isOne) {
			this.location = location;
		}
	}
	public String getLocation() {
		if (!isOne)
			return null;
		return  "Orator " + this.location.spot + " " + this.location.relation.name;
	}
}

