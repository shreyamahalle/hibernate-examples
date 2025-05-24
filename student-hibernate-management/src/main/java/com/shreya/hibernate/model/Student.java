package com.shreya.hibernate.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Student {
    int id;
    String name;
    double percentage;
}
