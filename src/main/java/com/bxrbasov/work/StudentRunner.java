package com.bxrbasov.work;

import java.util.ArrayList;
import java.util.List;

public class StudentRunner {
    public static void main(String[] args) {
        StudentFactory studentFactory = StudentFactory.getInstance();
        List<Student> students = new ArrayList<>(List.of(
                studentFactory.createStudent("Tommy Semenov", "B24-401",
                        1, List.of(5, 5, 5, 5, 5, 5, 5, 5)),
                studentFactory.createStudent("Sasha Antonov", "B23-501",
                        2, List.of(2, 2, 2, 2, 2, 2, 2, 2)),
                studentFactory.createStudent("Pasha Petrov", "B22-601",
                        3, List.of(4, 4, 4, 4, 4, 4, 4, 4)),
                studentFactory.createStudent("Dima Saharov", "B24-701",
                        1, List.of(3, 3, 3, 3, 3, 3, 3, 3)),
                studentFactory.createStudent("Nikita Popov", "B23-801",
                        2, List.of(5, 4, 3, 2, 5, 4, 3, 4))
        ));

        checkStudentsGrades(students);
        checkStudents(students, 3); //Всё работает, проверил :)
    }

    private static void checkStudentsGrades(List<Student> students) {
        for(int i = 0; i < students.size(); i++) {
            double grade = students.get(i).getGrades().stream()
                    .mapToInt(Integer::intValue)
                    .summaryStatistics()
                    .getAverage();
            if(grade < 3) {
                students.remove(i);
            } else {
                students.get(i).setCourse(students.get(i).getCourse() + 1);
            }
        }
    }

    private static void checkStudents(List<Student> students, int course) {
        for(Student student : students) {
            if(student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
