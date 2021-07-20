package _07_abstraction.thuc_hanh.Animal_Fruit;

public class Abstract_InterfaceTest {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chiken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chiken) {
                Edible edible = (Chiken) animal;
                System.out.println(edible.howToEat());
            }
        }

        Fruit[] fruit = new Fruit[2];
        fruit[0] = new Apple();
        fruit[1] = new Orange();
        for (Fruit fruit1 : fruit) {
            System.out.println(fruit1.howToEat());
        }
    }
}
