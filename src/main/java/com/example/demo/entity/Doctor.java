package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    private long id;
    private String name;
    private String gender;
    private int age;
    private Date workTime;
    private String technical;
    private String detail;
}
