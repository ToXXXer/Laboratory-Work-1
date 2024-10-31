package com.bxrbasov.work;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;
}
