package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        List<Integer> numbers = ReactiveSources.intNumbersFlux().log().toStream().toList();

        System.out.println("Number List - " + numbers);
        System.out.println("List Size - " + numbers.size());


        List<User> users = ReactiveSources.userFlux().toStream().toList();

        System.out.println("Users List - " + users);
        System.out.println("List Size - " + users.size());

        System.out.println("Press a key to end");
        System.in.read();
    }

}
