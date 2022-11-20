package CollectionsFramework_02.Comparable13;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        List<Person> peopleList = new ArrayList<>();
        Set<Person> peopleSet = new TreeSet<>();

        addElements(peopleList);
        addElements(peopleSet);

        Collections.sort(peopleList);

        System.out.println(peopleList);
        System.out.println(peopleSet);
    }
    private static void addElements(Collection collection) {
        collection.add(new Person(3, "Pens"));
        collection.add(new Person(4, "Ponos"));
        collection.add(new Person(2, "Tom"));
        collection.add(new Person(1, "Bo"));


    }
}
class Person implements Comparable<Person> {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name ;
    }


    @Override
    public int compareTo(Person o) {
        if (this.name.length() > o.getName().length()) {
            return -1;
        } else if (this.name.length() < o.getName().length()) {
            return 1;
        } else {
            return 0;
        }
    }
}