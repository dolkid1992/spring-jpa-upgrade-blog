package blogging.model;

import javax.persistence.*;

@Entity
@Table(name = "bloggers")
public class Blogger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String category;
    private String descriptions;

    public Blogger(){
    }

    public Blogger(String title, String category, String descriptions) {
        this.title = title;
        this.category = category;
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return String.format("Blogger{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
