package com.unizik.schoolunizik.service;

import com.unizik.schoolunizik.dtos.request.StudentDto;
import com.unizik.schoolunizik.dtos.request.UpDatedDto;
import com.unizik.schoolunizik.dtos.response.DeleteResponse;
import com.unizik.schoolunizik.dtos.response.RegistrationResponse;
import com.unizik.schoolunizik.dtos.response.UpDateResponse;
import com.unizik.schoolunizik.model.Students;
import com.unizik.schoolunizik.repository.StudentRepository;
import com.unizik.schoolunizik.util.Verification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    @Override
    public RegistrationResponse register(StudentDto studentDto) {
        Optional<Students> studentPhone_no = studentRepository.findByPhoneNumber(studentDto.getPhone_no());
        Optional<Students> students = studentRepository.findByEmail(studentDto.getEmail());

        if (students.isPresent()) {
            return new RegistrationResponse("STUDENT ALREADY EXIST");
        }

        if (!Verification.validEmail(studentDto.getEmail().trim().toLowerCase())) {
            return new RegistrationResponse(" INCORRECT EMAIL");
        }

        if (studentPhone_no.isPresent()) {
            return new RegistrationResponse("PHONE_NO ALREADY EXIST");
        }

        if (Verification.validPhone_no(studentDto.getPhone_no())) {
            return new RegistrationResponse("WRONG PHONE NUMBER");
        }

        Students students1 = Students.builder()
                .first_name(studentDto.getFirst_name())
                .last_name(studentDto.getLast_name())
                .email(studentDto.getEmail())
                .phoneNumber(studentDto.getPhone_no())
                .dob(LocalDate.parse(studentDto.getDob(), dateTimeFormatter))
                .age(studentDto.getAge())
                .build();
        studentRepository.save(students1);
        return new RegistrationResponse("STUDENT REGISTRATION SUCCESSFULLY");
    }

    @Override
    public List<Students> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public DeleteResponse delete(Long id) {
        Optional<Students> students = studentRepository.findById(id);
        if (students.isPresent()) {
            studentRepository.deleteById(id);
            return new DeleteResponse("student deleted");
        }
        return new DeleteResponse("student not found");
    }
@Override
    public UpDateResponse fix(UpDatedDto upDatedDto) {
        Optional<Students> students = studentRepository.findById(upDatedDto.getId());
        if (students.isPresent()) {
            Students students1 = students.get();
            students1.setFirst_name(upDatedDto.getFirst_name());
            students1.setLast_name(upDatedDto.getFirst_name());
            students1.setAge(upDatedDto.getAge());
            students1.setEmail(upDatedDto.getEmail());
            students1.setPhoneNumber(upDatedDto.getPhone_no());
            students1.setDob(LocalDate.parse(upDatedDto.getDob(),dateTimeFormatter));

        }
        return new UpDateResponse(" update successful");

    }
}



