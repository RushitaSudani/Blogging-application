package org.technous.bloggingApp.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    @NotEmpty
    @Size(min = 4,message = "your name contain minimum 4 character")
    private String name;
    @Email(message = "email not valid")
    private String email;
    @NotEmpty
    @Size(min = 3,max = 10,message = "password must be 3 to 10 character")
    private String password;
    @NotEmpty(message = "not empty")
    private String about;
}
