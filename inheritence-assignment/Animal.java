// Animal class
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Cat subclass overriding makeSound()
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        myAnimal.makeSound();  // Animal makes a sound

        Animal myCat = new Cat();
        myCat.makeSound();  // Meow
    }
}
