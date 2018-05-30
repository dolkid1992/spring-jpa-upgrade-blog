package blogging.model;

import javax.persistence.*;

@Entity
@Table(name = "bloger")
public class Bloger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameBlog;
    private String blogContent;

    public Bloger() {
    }

    public Bloger(String nameBlog, String blogContent) {
        this.nameBlog = nameBlog;
        this.blogContent = blogContent;
    }

    @Override
    public String toString() {
        return "Bloger{" +
                "id=" + id +
                ", nameBlog='" + nameBlog + '\'' +
                ", blogContent='" + blogContent + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
}
