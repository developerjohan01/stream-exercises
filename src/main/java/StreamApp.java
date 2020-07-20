public class StreamApp {
    public static void main(String[] args) {
        System.out.println("Stream");
        final Loop loop = new Loop();
//        loop.printListPeople(loop.personList);
//        System.out.println("---");
//        loop.printListPeopleStream(loop.personList);
        System.out.println("1---");
        loop.printListPeople(loop.listOfFemales());

        System.out.println("2---");
        loop.printListPeopleStream(loop.listOfPeople());

        System.out.println("3---");
        loop.printListPeopleStream(loop.listOfFemalesStream());

        System.out.println("4---");
        loop.printListPeopleStream(loop.listPeopleSortedStream(loop.listOfPeople()));

        System.out.println("5---");
        loop.printListPeopleStream(loop.listPeopleSortedReversedStream(loop.listOfPeople()));

        System.out.println("6---");
        loop.printOldest(loop.listOfPeople(),Gender.MALE);
        loop.printOldest(loop.listOfPeople(),Gender.FEMALE);

        System.out.println("6---");
        loop.printListPeopleStream(loop.listMales(loop.listOfPeople()));
//        loop.printListPeopleStream();
    }
}
