package com.unizik.schoolunizik.service;

import com.unizik.schoolunizik.dtos.request.StudentDto;
import com.unizik.schoolunizik.dtos.request.UpDatedDto;
import com.unizik.schoolunizik.dtos.response.DeleteResponse;
import com.unizik.schoolunizik.dtos.response.RegistrationResponse;
import com.unizik.schoolunizik.dtos.response.UpDateResponse;
import com.unizik.schoolunizik.model.Students;

import java.util.List;

public interface StudentService {
    RegistrationResponse register(StudentDto studentDto);

    List<Students> findAll();

    DeleteResponse delete(Long id);

    UpDateResponse fix(UpDatedDto upDatedDto);
}
