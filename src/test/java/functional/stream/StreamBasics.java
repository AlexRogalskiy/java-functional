package functional.stream;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StreamBasics {
    List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    void setup() {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
    }

    @Test
    public void streamExample() {
        numbers.stream()
            .filter(number -> number % 2 == 1) //Filter the odd numbers.
            .limit(4) //After 4th element stop the stream. Process first 4 element.
            .map(number -> number * 2) //Transform the number to number*2
            .forEach(System.out::println); //Print the results.
    }

    @Test
    public void streamDataFlowTest() {
        numbers.stream()
            .filter(number -> {
                System.out.println("Filter operation for number: " + number);
                return number % 2 == 1;
            }) //Filter the odd numbers.
            .limit(4) //After 4th element stop the stream. Process first 4 element.
            .map(number -> {
                System.out.println("Map operation for number: " + number);
                return number * 2;
            }) //Transform the number to number*2
            .forEach(number -> System.out.println("Result of stream: " + number)); //Print the results.
    }

    @Test
    public void streamOperationsTest() {
        System.out.println("Stream operations are starting!");
        numbers.stream()
            .filter(number -> {
                System.out.println("Filter operation for number: " + number);
                return number % 2 == 1;
            }) //Filter the odd numbers.
            .limit(4) //After 4th element stop the stream. Process first 4 element.
            .map(number -> {
                System.out.println("Map operation for number: " + number);
                return number * 2;
            }); //Transform the number to number*2
        //.forEach(number -> System.out.println("Result of stream: " + number)); //Print the results.
        //Note: Streams need terminal operations! forEach, collect, count, max, min, findAny, anyMatch, noneMatch, etc.
        System.out.println("Stream operations finished!");
    }
}
