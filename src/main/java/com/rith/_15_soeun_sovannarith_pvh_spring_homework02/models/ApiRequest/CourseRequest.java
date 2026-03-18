package com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String courseName;
    private String description;
    private Integer instructorId;
}
