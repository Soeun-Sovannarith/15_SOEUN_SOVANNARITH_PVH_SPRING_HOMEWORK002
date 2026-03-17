package com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest;


import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Integer> courseId;
}
