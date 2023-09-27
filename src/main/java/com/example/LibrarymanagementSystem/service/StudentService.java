package com.example.LibrarymanagementSystem.service;

import com.example.LibrarymanagementSystem.Enum.CardStatus;
import com.example.LibrarymanagementSystem.model.LibraryCard;
import com.example.LibrarymanagementSystem.repository.StudentRepository;
import com.example.LibrarymanagementSystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student) {
        LibraryCard libraryCard= new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);//set card for student

        Student savedStudent=studentRepository.save(student);// save both stu. and lc /no code in repo as hibernate doing byu its own
        return "Student added successfully";
    }

    public Student getStudent(int regNo) {
        Optional<Student> studentOptional = studentRepository.findById(regNo);// optional means may be present or may be not
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }
}
