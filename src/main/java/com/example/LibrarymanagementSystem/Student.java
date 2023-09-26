package com.example.LibrarymanagementSystem;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level =AccessLevel.PRIVATE)// All the methods and attri. become private in this class
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity//for telling  that this is a model class will be stored in  db
public class Student {
    @Id//regno is pk
    int regNo;
    String name;
    int age;
    String email;
    @Enumerated(EnumType.STRING)//will show gender in string form rather than 0,1,2
    Gender gender;
}
