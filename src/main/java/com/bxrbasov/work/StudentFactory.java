package com.bxrbasov.work;

import java.util.List;

public class StudentFactory {
    private static StudentFactory instance = new StudentFactory();

    public static StudentFactory getInstance() {
        return instance;
    }

    private StudentFactory(){}

    public Student createStudent(String name, String group, int course, List<Integer> grades) {
        return Student.builder()
                .name(name)
                .group(group)
                .course(course)
                .grades(grades)
                .build();
    }
}
