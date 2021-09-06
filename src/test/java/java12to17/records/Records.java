package java12to17.records;

import org.junit.jupiter.api.Test;

/**
 * Records reduce boilerplate code for classes that are simple data carriers:
 */
public class Records {

    /**
     * With below record declaration, we automatically define:
     * Private final fields for age, name, and team.
     * Canonical constructors for all fields.
     * Getters for all fields.
     * equals, hashCode, and toString for all fields.
     * <p>
     * Records are immutable (since their fields are private and final).
     * They are implicitly final.
     * We cannot define additional instance fields.
     * Always extend the Record class.
     */
    record Footballer(String name, int age, String team) {
    }

    //Canonical Constructor
    Footballer footballer = new Footballer("Ronaldo", 36, "Manchester United");

    @Test
    public void recordTest() {
        //Getters without get prefix
        System.out.println("Footballer's name: " + footballer.name);
        System.out.println("Footballer's age: " + footballer.age);

        record Basketballer(String name, int age) {
        }

        // equals
        boolean isFootballer1 = footballer.equals(new Footballer("Ozil", 32, "Fenerbahce")); // false
        System.out.println("Is first one footballer? " + isFootballer1);
        boolean isFootballer2 = footballer.equals(new Basketballer("Lebron", 36)); // false
        System.out.println("Is second one footballer? " + isFootballer2);
        boolean isFootballer3 = footballer.equals(new Footballer("Ronaldo", 36, "Manchester United")); // false
        System.out.println("Is third one footballer? " + isFootballer3);

        //hashcode
        int hashCode = footballer.hashCode(); // depends on values of x and y
        System.out.println("Hash Code of Record: " + hashCode);

        //toString
        String toStringOfRecord = footballer.toString();
        System.out.println("ToString of Record: " + toStringOfRecord);
    }

    /**
     * We can define additional methods.
     * Implement interfaces.
     * Customize the canonical constructor and accessors.
     */
    @Test
    public void record2Test() {
        record Engineer(String name, int age) {
            //Explicit canonical constructor
            Engineer {
                //Custom validation
                if (age < 1)
                    throw new IllegalArgumentException("Age less than 1 is not allowed!");
                //Custom modifications
                name = name.toUpperCase();
            }

            //Explicit accessor
            public int age() {
                return this.age;
            }
        }
        Engineer engineer1 = new Engineer("Onur", 39);
        System.out.println(engineer1);

        Engineer engineer2 = new Engineer("Alex", 0);
        System.out.println(engineer2);
    }

}
