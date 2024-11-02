package dto;

import com.example.ass2.model.Employee;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {

    Long id;

    String name;

    String content;

    Employee employee;
}
