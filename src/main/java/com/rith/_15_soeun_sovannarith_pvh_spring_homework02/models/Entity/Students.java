package com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {

    private Integer StudentId;
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Courses> courses;

}
