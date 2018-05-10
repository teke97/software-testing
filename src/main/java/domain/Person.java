package domain;

public class Person extends Human {
	private String name;

	public Person (String name) {
		super(true);
		this.name = name;
	}

	public void slide(){
		this.state = States.SLIDING.toString();
	}

	public void realise(){
		this.state = States.REALISING.toString();
	}

}