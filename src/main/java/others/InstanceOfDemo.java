package others;

public class InstanceOfDemo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        System.out.println(animal instanceof Animal);
        System.out.println(animal instanceof Dog);
        System.out.println(dog instanceof Animal);
        System.out.println(dog instanceof Dog);
    }
}

class Animal {

}

class Dog extends Animal {

}
