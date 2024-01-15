package classes_out;

class Animal {
    Number defineAge() {
        System.out.println("I'm a big animal");
        return 10;
    }

    Number defineAge(int value) {

        return 10;
    }

    Number defineAge(int value, int value2) {
        return 10;
    }
}

public class Dog extends Animal {
    Number defineAge (){
        System.out.println("I want to be big");
        return 5;
    }

    Number defineAge(int value, int value2, double d) {
        return 10;
    }

    static Number defineAge(String value, int value2, double d) {
        return 10;
    }

    public static void main(String[] args) {
        Animal animal = new Dog();
        Animal animal1 = new Animal();
        Dog.defineAge("asdf", 2, 3.0);
        animal1.defineAge();
        animal.defineAge();

    }
}
