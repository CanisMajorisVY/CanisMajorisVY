package entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Mihail on 21.03.2017.
 */
public class Student {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (listOfSubjects != null ? !listOfSubjects.equals(student.listOfSubjects) : student.listOfSubjects != null)
            return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = listOfSubjects != null ? listOfSubjects.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    private List<Subject> listOfSubjects;
    private int age;
    private String name;

    public Student(){
        listOfSubjects = new ArrayList<>();
    }

    public void addSubject(Subject subj){
        listOfSubjects.add(subj);
    }

    public String  getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getSBal(){
        int i = 0;
        int s = 0;
        Iterator<Subject> iterator = listOfSubjects.iterator();
        while (iterator.hasNext()){
            i++;
            s += iterator.next().getBall();
        }

        return s / i;
    }


}
