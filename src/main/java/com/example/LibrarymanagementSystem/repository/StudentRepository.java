package com.example.LibrarymanagementSystem.repository;

import com.example.LibrarymanagementSystem.Enum.Gender;
import com.example.LibrarymanagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>//interface bcoz orm will implement functionn methods
//
{
    List<Student> findByGender(Gender gender);//emlementation will be done by hibernate

    Student findByEmail(String email);

    Student findByGenderAndEmail(Gender gender, String email);
}
