package com.unizik.schoolunizik.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "UnizikStudents")
@Entity
public class Students {
    @Id
    @SequenceGenerator(name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1)

    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator = "student_sequence")

@Column(name = "id",
        updatable = false)
    private Long id;
    @Column( name = "first_name",
            nullable = false,
            columnDefinition = "TEXT",
            length = 30)
   private String first_name;

    @Column( name = "last_name",
            nullable = false,
            columnDefinition = "TEXT",
            length = 30)
    private String last_name;

    @Column( name = "email",
            nullable = false,
            columnDefinition = "TEXT")
    private String email;

    @Column( name = "dob",
            length = 30)
    private LocalDate dob;

    @Column( name = "phone_no",
            nullable = false)
    private String phoneNumber;

    @Column( name = "age",
            nullable = false)
    private Integer age;
}
