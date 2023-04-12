package com.unizik.schoolunizik.controller;

import com.unizik.schoolunizik.dtos.request.StudentDto;
import com.unizik.schoolunizik.dtos.request.UpDatedDto;
import com.unizik.schoolunizik.dtos.response.DeleteResponse;
import com.unizik.schoolunizik.dtos.response.RegistrationResponse;
import com.unizik.schoolunizik.dtos.response.UpDateResponse;
import com.unizik.schoolunizik.model.Students;
import com.unizik.schoolunizik.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/unizik")

public class Controller {
    private final StudentService studentService;

    @PostMapping("/registers")
    public RegistrationResponse registers(@RequestBody StudentDto studentDto) {
        return studentService.register(studentDto);
    }

    @GetMapping("/findAll")
    public List<Students> findAll() {
        return studentService.findAll();
    }
@DeleteMapping("/delete")
    public DeleteResponse delete(@RequestParam Long id) {
        return studentService.delete(id);
    }
@PutMapping("/fix")
    public UpDateResponse fix(@RequestBody UpDatedDto upDatedDto) {
        return studentService.fix(upDatedDto);
    }
}
