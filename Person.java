import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.*;

class Human {
    protected int id;
    protected String name;

    Human(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Person extends Human implements Comparable<Person> {
    
    private String gender;

    Person(int id, String name, String gender) {
        super(id, name);
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public String getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.gender;
    }

    @Override
    public int compareTo(Person p1) {
        return this.getName().compareTo(p1.getName());
    }


    public static void main(String[] args) {
        Person sankalp = new Person(1, "Sankalp", "Male");
        Person shashank = new Person(2, "Shashank", "Male");
        Person shraddha = new Person(3, "Shraddha", "Female");
        Person nishant = new Person(4, "Nishant", "Male");
        Person array[] = new Person[]{sankalp, shashank, shraddha, nishant};

        List<Person> persons = Arrays.asList(array);

    
        // To sort a user defined Colletion, The Collection must implement Comparable interface
        Collections.sort(persons);

        persons.stream().forEach((i)->System.out.println(i));

        long count = persons.stream().filter((person)->person.getGender().equals("Male")).count();
        
        persons.stream().map((person)-> person.getName() + "Saxena").forEach(i->System.out.println(i));
        
        Optional<Person> person = persons.stream().max((p1, p2)-> p1.getId()-p2.getId());
        System.out.println(person.get());

        System.out.println("Number of Male Peoples: " + count);

        int i = 69;

        Predicate<Integer> p = (Integer val)-> {
                int k;
                k = 10;
                k = k-2;
                if(val == 69) {
                    return true;
                }
                return false;
        };
        System.out.println(p.test(69));





    }
}