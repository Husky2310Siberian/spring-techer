package gr.aueb.cf.teacherapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentInsertDTO {


    @NotNull(message = "Firstname can not be null")
    @Size(min = 2, message = "Firstname mus be at least 2 characters long")
    private String firstname;

    @NotNull(message = "Lastname can not be null")
    @Size(min = 2, message = "Lastname mus be at least 2 characters long")
    private String lastname;

    @Pattern(regexp = "^[A-Z]\\d{5}", message = "Identity number must contain one char and five digits ")
    private String identityNumber;

    @NotNull(message = "Program is required")
    private Long programId;
}