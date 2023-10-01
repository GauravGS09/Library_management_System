package com.example.LibrarymanagementSystem.controller;


import com.example.LibrarymanagementSystem.dto.requesDTO.StudentRequest;
import com.example.LibrarymanagementSystem.dto.responeDTO.StudentResponse;
import com.example.LibrarymanagementSystem.service.StudentService;
import com.example.LibrarymanagementSystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity   addStudent(@RequestBody StudentRequest studentRequest){
        StudentResponse response=studentService.addStudent(studentRequest);
         return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo){
        Student student = studentService.getStudent(regNo);
        if(student!=null){
            return new ResponseEntity(student,HttpStatus.FOUND);
        }
        return new ResponseEntity("Invalid id!!",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get-males")
    public List<String> getAllMales(){
        List<String>  males = studentService.getAllMales();
        return males;
    }

}
