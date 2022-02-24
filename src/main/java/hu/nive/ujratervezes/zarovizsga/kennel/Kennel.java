package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        dogs.forEach(Dog::feed);
    }

    public Dog findByName(String name) {
        return dogs.stream()
                .filter(dog -> name.equals(dog.getName()))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Cannot find dog with name: " + name));
    }

    public void playWith(String name, int hours) {
        dogs.stream()
                .filter(dog -> name.equals(dog.getName()))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Cannot find dog with name: " + name))
                .play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        return dogs.stream()
                .filter(dog -> dog.getHappiness() > minHappiness)
                .map(Dog::getName)
                .toList();
    }

    public List<Dog> getDogs() {
        return List.copyOf(dogs);
    }
}
