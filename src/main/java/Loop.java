import java.util.*;
import java.util.stream.Collectors;

public class Loop {
    private List<Person> personList = listOfPeople();

    public List<Person> listOfPeople() {
        if (personList == null || personList.size() <= 0) {
            personList = List.of(
                    new Person(UUID.randomUUID(), "Adam Ant", 66, Gender.MALE),
                    new Person(UUID.randomUUID(), "Bob Builder", 77, Gender.UNKNOWN),
                    new Person(UUID.randomUUID(), "Eva Ericsen", 45, Gender.FEMALE),
                    new Person(UUID.randomUUID(), "Eva Eriksson", 44, Gender.FEMALE),
                    new Person(UUID.randomUUID(), "Johan Johansson", 33, Gender.MALE),
                    new Person(UUID.randomUUID(), "Mia Martin", 22, Gender.FEMALE),
                    new Person(UUID.randomUUID(), "Tom Thomson", 55, Gender.MALE),
                    new Person(UUID.randomUUID(), "Tom Thomson", 45, Gender.MALE)
            );
        }
        return personList;
    }

    /**
     * Imperative looping
     * @return
     */
    void printListPeople(List<Person> personList) {
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    void printListPeopleStream(List<Person> personList) {
        personList.stream().forEach(System.out::println);
    }

    /**
     * Imperative looping
     * @return
     */
    List<Person> listOfFemales() {
        List<Person> females = new ArrayList<>();
        for (Person person : personList) {
            if (person.getGender() == Gender.FEMALE) {
                females.add(person);
            }
        }
        return females;
    }

    List<Person> listOfFemalesStream() {
        return personList.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
    }

    List<Person> listPeopleSortedStream(List<Person> personList) {
        // personList.stream().sorted((person, t1) -> person.getAge()-t1.getAge()).forEach(System.out::println);
        return personList.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getName)).collect(Collectors.toList());
    }

    List<Person> listPeopleSortedReversedStream(List<Person> personList) {
        return personList.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getName).reversed()).collect(Collectors.toList());
    }

    Boolean isPeopleOlderAllMatchStream(List<Person> personList, Integer olderThan) {
        return personList.stream()
                .allMatch(person -> person.getAge() > olderThan);
    }

    Boolean isPeopleNameNoneMatchStream(List<Person> personList, String name) {
        return personList.stream().noneMatch(person -> person.getName().equals(name));
    }

    Optional<Person> oldestInListPeople(List<Person> personList) {
        return personList.stream()
                .max(Comparator.comparing(Person::getAge));
    }

    Map<Gender, List<Person>> groupListPeople(List<Person> personList) {
        return personList.stream().collect(Collectors.groupingBy(Person::getGender));
   }

   void printOldest(List<Person> personList, Gender gender) {
       Optional<String> oldest = personList.stream()
               .filter(person -> person.getGender().equals(gender))
               .max(Comparator.comparing(Person::getAge))
               .map(Person::getName);
       oldest.ifPresent(System.out::println);
   }
}
