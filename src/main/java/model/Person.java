package model;

/**
 * Created by yaros on 11.05.18.
 */
public class Person {
    private Name name;
    private Boolean isOne;
    private State state;

    public Person(Name name) {
        for (Name validName: Person.Name.values() ) {
            if(name == validName){
                this.name = name;
                if (this.name == Name.CREW){
                    this.isOne = false;
                    this.state = State.WAITING;
                } else {
                    this.isOne = true;
                    if (this.name == Name.ORATOR)
                        this.state = State.PREPARING;
                    else
                        this.state = State.SLIDING;
                }
            }
        }
    }

    public void oratory(Person crew, Person arthur){
        if(this.name != Name.ORATOR)
            return;
        if(crew.name != Name.CREW)
            return;
        this.state = State.ORATORING;
        crew.scream(arthur);
    }

    public void scream(Person arthur){
        if(this.name != Name.CREW)
            return;
        if(arthur.name != Name.ARTHUR)
            return;
        this.state = State.SCREAMING;
        arthur.realise();
    }

    public void realise() {
        if (this.name != Name.ARTHUR)
            return;
        this.state = State.REALISED_HE_IS_SLIDING;
    }

    public boolean isOne(){
        return isOne;
    }

    public Name getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public enum Name{ ORATOR, CREW, ARTHUR}

    public enum State{ PREPARING, ORATORING, WAITING, SCREAMING, SLIDING, REALISED_HE_IS_SLIDING}
}


