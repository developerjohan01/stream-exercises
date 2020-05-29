public class StreamApp {
    public static void main(String[] args) {
        System.out.println("Stream");
        final Loop loop = new Loop();
//        loop.printListPeople(loop.personList);
//        System.out.println("---");
//        loop.printListPeopleStream(loop.personList);
        System.out.println("---");
        loop.printListPeople(loop.listOfFemales());

        System.out.println("---");
        loop.printListPeopleStream(loop.listOfPeople());

        System.out.println("---");
        loop.printListPeopleStream(loop.listOfFemalesStream());

        System.out.println("---");
        loop.printListPeopleStream(loop.listPeopleSortedStream(loop.listOfPeople()));

        System.out.println("---");
        loop.printListPeopleStream(loop.listPeopleSortedReversedStream(loop.listOfPeople()));

        System.out.println("---");
        loop.printOldest(loop.listOfPeople(),Gender.MALE);
        loop.printOldest(loop.listOfPeople(),Gender.FEMALE);
//        loop.printListPeopleStream();
    }
}
