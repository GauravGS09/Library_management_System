package com.example.LibrarymanagementSystem.model;

import com.example.LibrarymanagementSystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level =AccessLevel.PRIVATE)// All the methods and attri. become private in this class
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity//for telling  that this is a model class will be stored in  db
public class Student //parent class
         {
    @Id//regno is pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int regNo;

    String name;

    int age;

    @Column(unique = true,nullable = false)// for not storing duplicate email
    String email;

    @Enumerated(EnumType.STRING)//will show gender in string form rather than 0,1,2
    Gender gender;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)//cascade means whatever CRUD opr. appied on parent it will be applied on child as well
    LibraryCard libraryCard;

}
