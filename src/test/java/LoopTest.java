import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LoopTest {

    Loop loopToTest;
    @BeforeEach
    void setUp() {
        loopToTest = new Loop();
    }

    @Test
    void listOfFemales() {
        assertEquals(3, loopToTest.listOfFemales().size());
    }

    @Test
    void listOfFemalesStream() {
        assertEquals(3, loopToTest.listOfFemalesStream().size());
    }

    @Test
    void listPeopleSortedStream() {
        List<Person> personList = loopToTest.listPeopleSortedStream(loopToTest.listOfPeople());
        assertEquals(8, personList.size());
        assertTrue(personList.get(0).getAge() < personList.get(1).getAge());
    }

    @Test
    void listPeopleSortedReversedStream() {
        List<Person> personList = loopToTest.listPeopleSortedReversedStream(loopToTest.listOfPeople());
        assertEquals(8, personList.size());
        assertTrue(personList.get(0).getAge() > personList.get(1).getAge());
    }

    @Test
    void listOfPeople() {
        List<Person> personList = loopToTest.listOfPeople();
        assertEquals(8, personList.size());
    }

    @Test
    void isPeopleOlderAllMatchStream() {
        List<Person> personList = loopToTest.listOfPeople();
        assertTrue(loopToTest.isPeopleOlderAllMatchStream(personList, 20));
        assertFalse(loopToTest.isPeopleOlderAllMatchStream(personList, 50));
    }

    @Test
    void isPeopleNameNoneMatchStream() {
        List<Person> personList = loopToTest.listOfPeople();
        assertFalse(loopToTest.isPeopleNameNoneMatchStream(personList, "Adam Ant"));
        assertTrue(loopToTest.isPeopleNameNoneMatchStream(personList, "James Bond"));
    }

    @Test
    void oldestInListPeople() {
        List<Person> personList = loopToTest.listOfPeople();
        Optional<Person> oldestInListPeople = loopToTest.oldestInListPeople(personList);
        assertNotNull(oldestInListPeople);
        assertEquals(Integer.valueOf(77), oldestInListPeople.get().getAge());
    }

}