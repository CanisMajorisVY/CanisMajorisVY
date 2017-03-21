package entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Mihail on 21.03.2017.
 */
public class Student {

    public Student( String name, int age){
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
