package ru.sbt.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class StreamTest {

    Stream<Student> stream;
    List<Student> studentList;


    @Before
    public void setUp() throws Exception {
        stream = new Stream<>();
        studentList = new ArrayList<>();
        studentList.add(new Student("Alex", 20, "java"));
        studentList.add(new Student("Vitya", 25, "python"));
        studentList.add(new Student("Ilia", 53, "C"));
        studentList.add(new Student("Gena", 40, "C++"));
        studentList.add(new Student(null, 40, "nothing"));
        stream = Stream.of(studentList);
    }


    @Test
    public void testFilter() throws Exception {
        assertEquals(stream.filter(s -> s.getName() != null).toList().size(), studentList.size() - 1);
        assertEquals(stream.filter(s -> s.getAge() <= 25).toList().size(), 2);
        
    }

    @Test
    public void testFormat() throws Exception {
        Stream<String> transform = stream.transform(Student::getFavoritSubject).filter(s -> !s.equals("java"));
        assertEquals(transform.toList().size(), 4);
    }

    @Test
    public void testToMap() throws Exception {
        Map<String, Integer> mapNameSubject = stream.toMap(Student::getName, Student::getAge);
    }

    @Test
    public void testPermanentList() throws Exception {
        List<Student> setStudent = new ArrayList<>(studentList);
        List<Integer> listAge = stream.filter(s -> s.getAge() > 20).transform(Student::getAge).toList();
        assertEquals(setStudent, studentList);
    }
}