package com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String email;
    private String phoneNumber;
    private Long courseId;
}
