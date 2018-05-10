package model;

/**
 * Created by yaros on 11.05.18.
 */
public class Person {
    private Name name;
    private Boolean isOne;

    public Person(Name name) {
        for (Name validName: Person.Name.values() ) {
            if(name == validName){
                this.name = name;
                if (this.name == Name.CREW){
                    this.isOne = false;
                } else {
                    this.isOne = true;
                }
            }
        }
    }

    public void oratory(Person crew, Person arthur){
        if(this.name != Name.ORATOR)
            return;
        if(crew.name != Name.CREW)
            return;
        crew.scream(arthur);
    }

    public void scream(Person arthur){
        if(this.name != Name.CREW)
            return;
        if(arthur.name != Name.ARTHUR)
            return;
        arthur.realise();
    }

    public void realise() {
        if (this.name != Name.ARTHUR)
            return;
    }

    public boolean isOne(){
        return isOne;
    }


    public enum Name{ ORATOR, CREW, ARTHUR}
}


