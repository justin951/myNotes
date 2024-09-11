package OOP.Person;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ean Craig", 11);
        Person person2 = new Person("Evan Ross", 12);

        System.out.println(person1.getName() + " is " + person1.getAge() + " years old.");
        System.out.println(person2.getName() + " is " + person2.getAge() + " years old.\n");

        person1.setAge(14);
        person2.setName("Lewis Jordan");
        person2.setAge(12);
        System.out.println("Set new age and name:");
        System.out.println(person1.getName() + " is now " + person1.getAge() + " years old.");
        System.out.println(person2.getName() + " is now " + person2.getAge() + " years old.");
    }
}
