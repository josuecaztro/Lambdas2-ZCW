import com.sun.tools.javac.comp.Check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SocialMedia implements CheckPerson {

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    //CORRECT APPROACH
    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

/*
    Your Mission:
    Using the 3rd approach, create a branch for
     each of the following implementations:

    Specify Search Criteria Code in a Local Class
    Specify Search Criteria Code in an Anonymous Class
    Specify Search Criteria Code with a Lambda Expression
    Don't forget your test!

 */

    public static void printPersonsOlderThan25 (List<Person> roster, CheckPerson tester){
        for (Person p : roster){
            if (tester.test(p)){
                p.printPerson();
            }
        }
    }

    public static void printAnonymousPersonsOlderThan25(CheckPerson tester){
        List<Person> roster = new ArrayList<>(Arrays.asList(
                new Person(),
                new Person(),
                new Person(),
                new Person()
        ));

        for (Person p : roster){
            if (tester.test(p)){
                p.printPerson();
            }
        }

    }

    public static void printPersonsOlderThan25WithLambda(List<Person> roster, CheckPerson tester){
        roster.forEach(p -> {
            if (tester.test(p)) {
                p.printPerson();
            }
        });

    }


    @Override
    public boolean test(Person p) {
        return p.getAge() > 25;
    }
}
