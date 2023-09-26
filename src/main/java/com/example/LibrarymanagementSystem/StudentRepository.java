package com.example.LibrarymanagementSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>//interface bcoz orm will implement functionn methods  {
}
