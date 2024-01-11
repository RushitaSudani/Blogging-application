package org.technous.bloggingApp.models;
import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryid;
    @Column(name = "categorytitle")
    private String categorytitle;
    @Column(name = "categorydescription")
    private String categorydescription;

    @OneToMany(mappedBy = "categories",cascade = CascadeType.ALL)
    private List<Post> list=new ArrayList<>();

}
