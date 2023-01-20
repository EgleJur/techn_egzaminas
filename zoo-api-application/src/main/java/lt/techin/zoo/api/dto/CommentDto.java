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

    public CommentDto( Long id, String author, String text, Article article) {
this.id = id;
        this.author = author;
        this.text = text;
        this.article = article;
    }


    public String getAuthor() {
        return author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
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
    public String toString() {
        return "CommentDto{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", article=" + article +
                '}';
    }
}
