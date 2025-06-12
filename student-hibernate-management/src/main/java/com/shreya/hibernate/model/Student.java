package com.shreya.hibernate.model;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity                      // ✅ Required for Hibernate to treat this as a mapped entity
@Table(name = "student")     // ✅ Optional: specify DB table name
public class Student {

    @Id                     // ✅ Required: Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Optional: Auto-increment
    private int id;

    private String name;

    private double percentage;
}
