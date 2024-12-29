package gr.aueb.cf.teacherapp.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserInsertDTO {

    @Email
//  @NotNull(message = "Username must not be null")
//  @Size(min = 3, max = 20,message = "Username must be between 3 to 20 characters")
    private String username;

    @NotNull
    @Pattern(regexp = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\\d)(?=.*?[@$!%*?&]).{5,}$", message = "Invalid password")
    private String password;

    private String role;
}
