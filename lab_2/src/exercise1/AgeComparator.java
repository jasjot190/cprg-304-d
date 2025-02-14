package exercise1;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    // Implement compare method for Comparator interface (age-based comparison)
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getAge() == s2.getAge()) {
            return s1.getName().compareTo(s2.getName()); // If ages are equal, compare by name
        }
        return Integer.compare(s1.getAge(), s2.getAge()); // Compare by age
    }
}