package org.iesvdm.kata1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise1Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    public void getFirstNamesOfAllPeople()
    {
        //TODO
        // Replace empty list firstNames with a stream transformation on people.
        List<String> firstNames = new ArrayList<>(); // this.people...

        var expectedFirstNames = Arrays.asList("Mary", "Bob", "Ted", "Jake", "Barry", "Terry", "Harry", "John");
        firstNames = this.people.stream()
                .map(Person::getFirstName)
                .toList();
        Assertions.assertIterableEquals(expectedFirstNames, firstNames);
    }

    @Test
    @Tag("KATA")
    public void getNamesOfMarySmithsPets()
    {
        Optional<Person> optionalPerson = this.getPersonNamed("Mary Smith");
        List<String> names = new ArrayList<>();
        if (optionalPerson.isPresent()) {
            List<Pet> pets = optionalPerson.get().getPets();

            //TODO
            // Replace empty list name with a stream transformation on pets.
            names = optionalPerson.stream().map(p -> String.valueOf(p.getPets().stream().map(Pet::getName).toList())).toList();

            names.forEach(System.out::println);
        }
        System.out.println(names);
        Assertions.assertEquals("Tabby", names.getFirst()); //TODO
    }

    @Test
    @Tag("KATA")
    @DisplayName("getPeopleWithCats 🐱")
    public void getPeopleWithCats()
    {
        //TODO
        // Replace empty list with a positive filtering stream on people

        // Option 1

        List<String> peopleWithCats = this.people.stream()
                .filter(p -> p.getPetTypes().containsKey(PetType.CAT))
                .map(Person::getLastName)
                .toList();;  // this.people...

        var expectedFirstNames = Arrays.asList("Smith", "Smith");

        Assertions.assertEquals(expectedFirstNames, peopleWithCats);
    }

    @Test
    @Tag("KATA")
    @DisplayName("getPeopleWithoutCats 🐱")
    public void getPeopleWithoutCats()
    {
        //TODO
        // Replace empty list with a negative filtering stream on people

        // Option 1

        List<String> peopleWithoutCats = this.people.stream()
                .filter(p -> !p.getPetTypes().containsKey(PetType.CAT))
//                .filter(p -> !p.hasPet(PetType.CAT))
                .map(Person::getLastName)
                .toList();;  // this.people...

        var expectedFirstNames = Arrays.asList("Smith", "Snake", "Bird", "Turtle", "Hamster", "Doe");

        Assertions.assertIterableEquals(expectedFirstNames, peopleWithoutCats);
    }
}
