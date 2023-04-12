package com.unizik.schoolunizik.dtos.request;

import lombok.*;


import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto implements Serializable {

    private String first_name;
    private String last_name;
    private String email;
    private String dob;
    private String phone_no;
    private Integer age;
}
