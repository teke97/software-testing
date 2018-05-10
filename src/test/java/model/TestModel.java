package model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yaros on 11.05.18.
 */
public class TestModel {
    private Person arthur;
    private Person crew;
    private Person orator;


    @Before
    public void init(){
        arthur = new Person(Person.Name.ARTHUR);
        crew = new Person(Person.Name.CREW);
        orator = new Person(Person.Name.ORATOR);
    }

    @Test
    public void isOneTest() {
        assertEquals(true, arthur.isOne());
        assertEquals(true, orator.isOne());
        assertEquals(false, crew.isOne());

    }

    @Test
    public void initParams(){
        assertEquals(Person.State.SLIDING,arthur.getState());
        assertEquals(Person.State.PREPARING, orator.getState());
        assertEquals(Person.State.WAITING, crew.getState());
    }
}
