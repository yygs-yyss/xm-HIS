package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {
    private String id;
    private double cost;
    private String prescription;
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime createTime;
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime updateTime;
}
