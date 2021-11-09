package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    @NotNull
    private String userName;
    @NotNull
    private String password;
    private String title;
    private String graduationSchool;
    private Integer role;
    private String detail;
    private int age;
    private String gender;
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime createTime;

    @TableField(updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime updateTime;
}