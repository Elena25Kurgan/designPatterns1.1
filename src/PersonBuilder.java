public class PersonBuilder implements IPersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    public Person build() {
        Person person = new Person(name, surname, age, city);
        try {
            if ((age < 0) || (age > 150)) {
                throw new IllegalStateException("Возраст указан не корректно!");
            }
            if (surname == null) {
                throw new IllegalStateException("Фамилия не может быть пустой!");
            }
            if (name == null) {
                throw new IllegalStateException("Имя не может быть пустым!");
            }
        }
        catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
        return person;
    }
}