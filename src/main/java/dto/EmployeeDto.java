package dto;

import com.example.ass2.model.Email;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    Long id;

    String name;
    Long age;
    Long salary;

    List<Email> email;
}
