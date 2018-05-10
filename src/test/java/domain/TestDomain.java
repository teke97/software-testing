package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by yaros on 20.04.18.
 */
public class TestDomain {
    Construction building = new Construction("Building");
    Construction window = new Construction("Window");
    Construction platform = new Construction("Platform");
    Human crowd = new Human(false);
    Human orator = new Human(true);
    Person arthur = new Person("Arthur");

    @Before
    public void setLocations(){
        building.setLocation(new Location("behind", platform));
        window.setLocation(new Location("in", building));
        platform.setLocation(new Location("in front of", building));

    }

    @Test
    public void oratoryTest(){
        orator.oratory();
        crowd.oratory();
        assertEquals(States.ORATORYING.toString(), orator.state);
        assertNotEquals(States.ORATORYING.toString(), crowd.state);
    }
    @Test
    public void screamTest(){
        orator.scream();
        crowd.scream();
        assertNotEquals(States.MILLING.toString(), orator.state);
        assertEquals(States.MILLING.toString(), crowd.state);
    }

    @Test
    public void slideTest(){
        arthur.slide();
        assertEquals(States.SLIDING.toString(),arthur.state);
    }
    @Test
    public void realiseTest(){
        arthur.realise();
        assertEquals(States.REALISING.toString(),arthur.state);
    }
    @Test
    public void checkLocationsTest(){
        assertEquals("Building behind Platform",building.getLocation() );
        assertEquals("Platform in front of Building",platform.getLocation() );
        assertEquals("Window in Building",window.getLocation() );
    }
    @Test
    public void oratorLocationTest(){
        orator.setLocation(new Location("on", platform));
        crowd.setLocation(new Location("anywhere", building));
        assertEquals("Orator on Platform", orator.getLocation());
        assertNull( crowd.getLocation());
    }

}
