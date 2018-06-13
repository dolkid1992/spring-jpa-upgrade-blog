package blogging.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Blogger.class)
    private List<Blogger> bloggers;

    public Category(){
    }

    public Category(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blogger> getBloggers() {
        return bloggers;
    }

    public void setBloggers(List<Blogger> bloggers) {
        this.bloggers = bloggers;
    }
}
