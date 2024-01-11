package org.technous.bloggingApp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.technous.bloggingApp.models.Categories;
import org.technous.bloggingApp.models.User;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PostDTO {
    @NotEmpty(message = "Must have Post Title")
    @Size(min = 3,max = 30,message = "Post Title Must Contain 3 to 30 Letters")
    private String title;
    @Size(min = 3,max = 2000,message = "Post Content Must In Between 2 to 2000 letters")
    private String content;

    private String imageName;
    private Date addedDate;
    private CategotyDTO categories;
    private UserDTO user;

}
