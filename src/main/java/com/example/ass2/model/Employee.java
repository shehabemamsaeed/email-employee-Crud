package com.example.ass2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull
    @NotEmpty
    String name;
     @Min(15)
     @Max(40)
    Long age;
    @Range(min = 5000, max = 10000)
    Long salary;

    @OneToMany(cascade = CascadeType.ALL)
    List<Email> email;
}
