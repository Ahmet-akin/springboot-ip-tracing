package com.ravindra.springbootiptracing.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
This Exception class to handle the exception if IP Not Found in database
 */
@Setter
@Getter
//@ResponseStatus( code = HttpStatus.BAD_REQUEST, reason = "No Data Found in Database")
public class IPNotFoundException extends RuntimeException {

    private String msg;

    public IPNotFoundException(){

    }
    public IPNotFoundException(String msg){
        this.msg = msg;
    }
    @Override
    public String toString(){
        return "Exception message" + msg;
    }
}
