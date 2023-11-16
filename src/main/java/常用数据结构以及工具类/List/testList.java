package 常用数据结构以及工具类.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class testList {

    public static void main(String[] args) {
        Student a=new Student("a",1,"thu");
        Student b=new Student("b",2,"pku");
        Student c=new Student("c",3,"bupt");

        List<Student> list=new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);

        int size = list.size();
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.number==2){
                list.remove(student);
            }
        }
//        Iterator<Student> iterator = list.iterator();
//        for (Student student : list) {
//            if (student.number==2){
//                list.remove(student);
//            }
//        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).name);
        }


    }
}


class Student{
    public String name;
    public Integer number;

    public String school;
    Student(String name,Integer number,String school){
       this.number=number;
       this.name=name;
       this.school=school;
    }
}