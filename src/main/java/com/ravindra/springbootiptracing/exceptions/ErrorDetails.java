package com.ravindra.springbootiptracing.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorDetails {
    private int code;
    private String msg;

    public ErrorDetails() {


    }

    public ErrorDetails(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
