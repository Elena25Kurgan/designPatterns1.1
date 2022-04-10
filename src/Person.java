import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String city;

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return city.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age >= 0) return OptionalInt.of(age);
        else return OptionalInt.empty();
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String address) {
        this.city = address;
    }

    public void happyBirthday() {
        this.age++;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname +
                " в возрасте " + this.age + " лет, проживающий в городе " +
                this.city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getAddress());
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setSurname(surname);
        personBuilder.setAge(0);
        personBuilder.setAddress(city);
        return personBuilder;
    }
}