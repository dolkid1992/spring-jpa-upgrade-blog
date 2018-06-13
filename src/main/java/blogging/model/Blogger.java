package blogging.model;

import javax.persistence.*;

@Entity
@Table(name = "bloggers")
public class Blogger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String descriptions;

    public Blogger(){
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Blogger(String title, String author, String descriptions) {
        this.title = title;
        this.author = author;
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return String.format("Blogger{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", descriptions='" + descriptions + '\'' +
                '}');
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
