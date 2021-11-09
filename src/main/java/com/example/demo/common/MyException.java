package com.example.demo.common;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException {
    private int code;
    public MyException(int code, String message) {
        super(message);
        this.code=code;
    }
}
