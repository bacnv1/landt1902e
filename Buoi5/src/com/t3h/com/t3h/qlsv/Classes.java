package com.t3h.com.t3h.qlsv;

import java.util.ArrayList;
import java.util.Comparator;

public class Classes {
    private ArrayList<Student> arr = new ArrayList<>();

    public void add(Student student) {
        arr.add(student);
    }

    public void update(int index, Student student) {
        arr.set(index, student);
    }

    public void delete(int index) {
        arr.remove(index);
    }

    public void sort() {
        arr.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getScore() < o2.getScore()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public void updateScore(int score) {
        for (Student s : arr) {
            if (s.getScore() <= score) {
                s.setScore(s.getScore() + 3);
            }
        }
    }

    public void deleteScore(int score) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (arr.get(i).getScore() < score){
                arr.remove(i);
            }
        }
    }

    public void print() {
        for (Student s : arr) {
            s.inThongTin();
        }
    }
}
