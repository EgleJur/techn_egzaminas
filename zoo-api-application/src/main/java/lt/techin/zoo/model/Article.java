package lt.techin.zoo.model;


import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String description;

    @CreatedDate
    private LocalDateTime createdDate;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();

    }

    public Article() {
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

      public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
