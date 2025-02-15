package IteratorsAndCompartors.exercise.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String command = scanner.nextLine();

        while (!command.equals("END")){
            String[] tokens = command.split("\\s+");

            String name = tokens[0];
            Integer age = Integer.valueOf(tokens[1]);
            String town = tokens[2];
            Person person = new Person(name, age, town);
            people.add(person);

            command = scanner.nextLine();
        }
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        Person specialPerson = people.get(index);

        int equalPeople = 0;
        for (Person person : people) {
            if (person.compareTo(specialPerson) == 0){
                equalPeople++;
            }
        }
        if (equalPeople == 1){
            System.out.println("No matches");
        }else{
            System.out.printf("%d %d %d", equalPeople, people.size() - equalPeople, people.size());
        }
    }
}
