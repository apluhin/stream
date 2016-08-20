package ru.sbt.stream;

public class Student {

    private String name;
    private int age;
    private String favoritSubject;


    public Student(String name, int age, String favoritSubject) {
        this.name = name;
        this.age = age;
        this.favoritSubject = favoritSubject;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFavoritSubject() {
        return favoritSubject;
    }
}
