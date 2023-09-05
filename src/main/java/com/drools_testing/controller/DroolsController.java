package com.drools_testing.controller;

import com.drools_testing.entity.StudentDto;
import com.drools_testing.service.DroolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DroolsController {

    private final DroolService droolService;

    public DroolsController(DroolService droolService) {
        this.droolService = droolService;
    }
    @PostMapping("/student/marksDiscount")
    public ResponseEntity<StudentDto>getDiscountOnStudentObtainedGrades(@RequestBody StudentDto studentDto){
        return  new ResponseEntity<>(droolService.getDroolsFunctionalityTest(studentDto), HttpStatus.ACCEPTED);
    }
    @RequestMapping(path = "/user")
    public void check(){

    }
}
