package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentDb=new HashMap<>();
    HashMap<String,Teacher> teacherDb=new HashMap<>();
    HashMap<String,List<String>> teacherStudentPair=new HashMap<>();

    public void addStudent(Student student){
        String key=student.getName();
        studentDb.put(key,student);
    }
    public void addTeacher(Teacher teacher){
        String key=teacher.getName();
        teacherDb.put(key,teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
        List<String> students=new ArrayList<>();
        if(!teacherStudentPair.containsKey(teacher)){

        }
        else {
            students = teacherStudentPair.get(teacher);
        }
        students.add(student);
        teacherStudentPair.put(teacher,students);
    }
    public Student getStudentByName(String name){
        return studentDb.get(name);
    }
    public Teacher getTeacherByName(String name){
        return teacherDb.get(name);
    }
    public List<String> getStudentsByTeacherName(String teacher){
        List<String> students=teacherStudentPair.get(teacher);
        return students;
    }
    public List<String> getAllStudents(){
        List<String> students=new ArrayList<>();
        for(String name: studentDb.keySet()){
            students.add(name);
        }
        return students;
    }
    public void deleteTeacher(String teacher){
        teacherDb.remove(teacher);
        List<String>students=teacherStudentPair.get(teacher);
        for(String name:students){
            studentDb.remove(name);
        }
        teacherStudentPair.remove(teacher);
    }
    public void deleteAllTeachers(){
        teacherDb=new HashMap<>();
        for(String teacher:teacherStudentPair.keySet()){
            List<String>students=teacherStudentPair.get(teacher);
            for(String name:students){
                studentDb.remove(name);
            }
            teacherStudentPair.remove(teacher);
        }
    }
}
