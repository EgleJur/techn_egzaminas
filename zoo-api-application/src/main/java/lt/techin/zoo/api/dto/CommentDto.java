package lt.techin.zoo.api.dto;


import lt.techin.zoo.model.Article;
import java.util.Objects;

public class CommentDto {

    private Long id;
    private String author;

    private String text;


    private Article article;


    public CommentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
  public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Article getRoom() {
        return article;
    }

    public void setRoom(Article article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDto that = (CommentDto) o;
        return Objects.equals(id, that.id) && Objects.equals(author, that.author) && Objects.equals(text, that.text) && Objects.equals(article, that.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, text, article);
    }
}
