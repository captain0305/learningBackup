package com.captainx.learningBackup.常用数据结构以及工具类.comparator;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TestComparable {
    public static void main(String[] args) {
        List<Student> studentList = new LinkedList<>();
        studentList.add(new Student("Alice", 25));
        studentList.add(new Student("Bob", 20));
        studentList.add(new Student("Charlie", 22));

        // 使用AgeComparator对studentList链表进行排序
//        Collections.sort(studentList, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.getAge()-o1.getAge();
//            }
//        });
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()- o2.getAge();
            }
        });
        // 打印排序后的结果
        for (Student student : studentList) {
            System.out.println(student.getName() + " - " + student.getAge() + " years old");
        }
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
