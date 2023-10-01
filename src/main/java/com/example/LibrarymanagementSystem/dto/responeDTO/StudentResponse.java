package com.example.LibrarymanagementSystem.dto.responeDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    String name;
    String email;

    String message;

    String cardIssuedNo;
}
