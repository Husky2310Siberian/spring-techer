package gr.aueb.cf.teacherapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherReadOnlyDTO {

    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String firstname;
    private String lastname;
    private String uuid;
    private String vat;
    private String region;
}
