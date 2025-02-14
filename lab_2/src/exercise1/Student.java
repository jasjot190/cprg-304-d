package exercise1;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }

    // Implement compareTo method for Comparable interface (name-based comparison)
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}