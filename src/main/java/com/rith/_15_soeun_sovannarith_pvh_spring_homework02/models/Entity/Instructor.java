package com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {

    private Integer instructorId;
    private String instructorName;
    private String email;
}
