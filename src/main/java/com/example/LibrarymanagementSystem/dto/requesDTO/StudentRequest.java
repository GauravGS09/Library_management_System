package com.example.LibrarymanagementSystem.dto.requesDTO;

import com.example.LibrarymanagementSystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    String name;
    int age;

    String email;

    Gender gender;

}
