package com.unizik.schoolunizik.dtos.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpDatedDto {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String dob;
    private String phone_no;
    private Integer age;

}
