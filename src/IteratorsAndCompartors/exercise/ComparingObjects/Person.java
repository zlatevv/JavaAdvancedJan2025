package IteratorsAndCompartors.exercise.ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private Integer age;
    private String town;

    public Person(String name, Integer age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person person) {
        int nameResult = this.name.compareTo(person.name);
        int ageResult = this.age.compareTo(person.age);
        int townResult = this.town.compareTo(person.town);
        if (nameResult != 0){
            return nameResult;
        }else if (ageResult != 0) {
            return ageResult;
        }else if (townResult != 0){
            return townResult;
        }
        return 0;
    }
}
