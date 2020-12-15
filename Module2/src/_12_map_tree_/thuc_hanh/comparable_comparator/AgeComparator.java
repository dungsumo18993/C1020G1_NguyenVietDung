package _12_map_tree_.thuc_hanh.comparable_comparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getAge().compareTo(o1.getAge());
    }
}
