package com.example.LibrarymanagementSystem.service;

import com.example.LibrarymanagementSystem.Enum.CardStatus;
import com.example.LibrarymanagementSystem.Enum.Gender;
import com.example.LibrarymanagementSystem.dto.requesDTO.StudentRequest;
import com.example.LibrarymanagementSystem.dto.responeDTO.StudentResponse;
import com.example.LibrarymanagementSystem.model.LibraryCard;
import com.example.LibrarymanagementSystem.repository.StudentRepository;
import com.example.LibrarymanagementSystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public StudentResponse addStudent(StudentRequest studentRequest) {
        //conver dto req. to model

        Student student=new Student();

        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student.setGender(studentRequest.getGender());
        student.setEmail(studentRequest.getEmail());

        //give a library card
        LibraryCard libraryCard= new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);//set card for student

        Student savedStudent=studentRepository.save(student);// save both stu. and lc /no code in repo as hibernate doing byu its own

        //save model to response dto
        StudentResponse studentResponse=new StudentResponse();
           studentResponse.setName(savedStudent.getName());
           studentResponse.setEmail(savedStudent.getEmail());
           studentResponse.setMessage("You have been registered");
           studentResponse.setCardIssuedNo(savedStudent.getLibraryCard().getCardNo());

           return studentResponse;

    }

    public Student getStudent(int regNo) {
        Optional<Student> studentOptional = studentRepository.findById(regNo);// optional means may be present or may be not
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }

    public List<String> getAllMales() {
      List<String> names= new ArrayList<>();
      List<Student> students =studentRepository.findByGender(Gender.MALE);
      for(Student s:students){
          names.add(s.getName());
      }
      return names;
    }
}
