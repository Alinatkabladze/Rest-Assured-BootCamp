import WithRecord.Person;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ExampleTest {

    Person person = new Person("John Doe", "100 Linda Ln.");

    @Test
    public void givenValidNameAndAddress_whenGetNameAndAddress_thenExpectedValuesReturned() {
        String name = "John Doe";
        String address = "100 Linda Ln.";

        Person person = new Person(name, address);

        assertEquals(name, person.name());
        assertEquals(address, person.address());
    }

    @Test
    public void givenSameNameAndAddress_whenEquals_thenPersonsEqual() {
        String name = "John Doe";
        String address = "100 Linda Ln.";

        Person person1 = new Person(name, address);
        Person person2 = new Person(name, address);

        assertTrue(person1.equals(person2));
    }

    @Test
    public void givenSameNameAndAddress_whenHashCode_thenPersonsEqual() {
        String name = "John Doe";
        String address = "100 Linda Ln.";

        Person person1 = new Person(name, address);
        Person person2 = new Person(name, address);

        assertEquals(person1.hashCode(), person2.hashCode());
    }

}
