package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpaceshipTests {
    private Astronaut astronaut;
    private Spaceship spaceship;
    @Before
    public void setUp(){
        this.astronaut=new Astronaut("Pesho",100);
        this.spaceship=new Spaceship("Ship",15);
    }
    @Test
    public void testAstronautConstructor(){
        Assert.assertEquals("Pesho",astronaut.getName());
        Assert.assertEquals(100,astronaut.getOxygenInPercentage(),0.00);
    }
    @Test
    public void testSpaceshipCntr(){
        Assert.assertEquals("Ship",spaceship.getName());
        Assert.assertEquals(15,spaceship.getCapacity());
    }
    @Test
    public void testGetCount(){
        Assert.assertNotNull(this.spaceship.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacity(){
        new Spaceship("Ship",-1);
    }
    @Test(expected = NullPointerException.class)
    public void testSetName(){
        new Spaceship("",15);
    }
    @Test(expected = NullPointerException.class)
    public void testSetName2(){
        new Spaceship(null,15);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalid() {
        Astronaut astronaut1 = new Astronaut("s", 12);
        Astronaut astronaut2 = new Astronaut("d", 10);
        Spaceship spaceship1 = new Spaceship("def", 1);
        spaceship1.add(astronaut1);
        spaceship1.add(astronaut2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAdd2(){
        Astronaut astronaut1 = new Astronaut("s", 12);
        Astronaut astronaut2 = new Astronaut("s", 12);

        Spaceship spaceship1 = new Spaceship("def", 2);
        spaceship1.add(astronaut1);
        spaceship1.add(astronaut2);
    }
    @Test
    public void testAdd(){
        this.spaceship.add(astronaut);
    }
    @Test
    public void testRemove(){
        List<Astronaut>astronauts=new ArrayList<>();
        Astronaut astronaut2 = astronauts
                .stream()
                .filter(a -> a.getName().equals(spaceship.getName()))
                .findFirst()
                .orElse(null);
        this.spaceship.add(astronaut);
        this.spaceship.remove(astronaut.getName());
    }
    @Test
    public void testRemove2(){
       this.spaceship.add(astronaut);
     //  this.spaceship.remove(astronaut.getName());
       Assert.assertTrue(this.spaceship.remove(astronaut.getName()));
    }

}
