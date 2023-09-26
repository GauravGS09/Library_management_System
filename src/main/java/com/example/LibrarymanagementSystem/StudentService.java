package com.example.LibrarymanagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired StudentRepository studentRepository;
    public Student addStudent(Student student) {
        Student savedStudent=studentRepository.save(student);//no code in repo as hibernate doing byu its own
        return savedStudent;
    }

    public Student getStudent(int regNo) {
        Optional<Student> studentOptional = studentRepository.findById(regNo);// optional means may be present or may be not
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }
}
