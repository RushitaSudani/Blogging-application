package org.technous.bloggingApp.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.technous.bloggingApp.models.Categories;
import org.technous.bloggingApp.models.User;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postid;
    @Column(name = "title",length = 100)
    private String title;
    @Column(name = "content",length = 7000)
    private String content;
    @Column(name = "imageName")
    private String imageName;
//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "addedDate")
    private Date addedDate;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Categories categories;

    @ManyToOne()
    private User user;

}
