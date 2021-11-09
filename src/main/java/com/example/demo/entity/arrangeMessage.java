package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class arrangeMessage {
    private long id;
    private String lesson;
    private String name;
    private String technical;
}
