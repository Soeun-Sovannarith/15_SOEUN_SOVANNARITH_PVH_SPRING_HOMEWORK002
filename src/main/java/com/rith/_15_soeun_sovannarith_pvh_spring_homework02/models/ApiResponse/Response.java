package com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiResponse;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response <T> {
    private Boolean success;
    private HttpStatus status;
    private String msg;
    private T payload;
    private Instant timestamp;

    public static <T> Response<T> ResponseSuccess(T payload) {
        return new Response<>(true, HttpStatus.OK, "Data Fetched Successfully", payload,Instant.now());
    }
    public static <T> Response<T> ResponseFail(){
        return new Response<>(false,HttpStatus.NOT_FOUND,"The Data might not exist",null,Instant.now());
    }



}
