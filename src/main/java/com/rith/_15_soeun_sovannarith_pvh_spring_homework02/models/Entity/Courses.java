package com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Courses {
    private Integer courseId;
    private String courseName;
    private String description;
    private List<Instructor> instructor;
}
