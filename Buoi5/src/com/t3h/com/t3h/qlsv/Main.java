package com.t3h.com.t3h.qlsv;

public class Main {
    public static void main(String[] args) {
        Classes clz = new Classes();
        Student student = new Student("Nguyen Van A", 12, 10);
        clz.add(student);
        Student student1 = new Student("Nguyen Van B", 20, 1.4f);
        clz.add(student1);
        Student student2 = new Student("Tran Thi B", 14, 3.2f);
        clz.add(student2);
//        Student student3 = new Student("Tran Thi B", 21, 9.2f);
//        clz.update(2, student3);
        clz.sort();
        clz.updateScore(5);
        clz.deleteScore(5);
        clz.print();
    }
}
