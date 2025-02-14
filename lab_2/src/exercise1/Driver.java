package exercise1;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {

    public static void main(String[] args) {

        ArrayList<Student> studs = new ArrayList<>();
        studs.add(new Student("Smith", 34));
        studs.add(new Student("Johnson", 21));
        studs.add(new Student("Williams", 67));
        studs.add(new Student("Brown", 53));
        studs.add(new Student("Jones", 48));
        studs.add(new Student("Miller", 36));
        studs.add(new Student("Davis", 44));
        studs.add(new Student("Wilson", 52));
        studs.add(new Student("Anderson", 34));
        studs.add(new Student("Moore", 33));

        // Display the list before sorting
        System.out.println("Before sorting:");
        System.out.println(studs);

        // Sort using Comparable (name-based sorting)
        Collections.sort(studs);
        System.out.println("\nAfter sorting by name (Comparable):");
        System.out.println(studs);

        // Sort using Comparator (age-based sorting)
        Collections.sort(studs, new AgeComparator());
        System.out.println("\nAfter sorting by age (Comparator):");
        System.out.println(studs);
    }
}