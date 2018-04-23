package ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo;

import java.util.HashSet;

public class Subject{
private int subject_id;
private String name;
private int teacher_id;
private HashSet<Student> students;

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public void setStudents(HashSet<Student> students) {
        this.students = students;
    }

    public void addStudents(Student student){
        students.add(student);
    }
    public void deleteStudent(Student student){
        students.remove(student);
    }
}
