package gr.aueb.cf.teacherapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherInsertDTO {

    @NotNull(message = "firstname can not be null")
    @Size(min = 2 , message = "firstname must be at least 2 characters long")
    private String firstname;

    @NotNull(message = "firstname can not be null" )
    @Size(min = 2, message = "firstname must be at least 2 characters long")
    private String lastname;

    @Pattern(regexp = "\\d{9,}", message = "vat must be at least 9 digits")
    private String vat;

    @NotNull(message = "region must not be null")
    private Long regionId;

}