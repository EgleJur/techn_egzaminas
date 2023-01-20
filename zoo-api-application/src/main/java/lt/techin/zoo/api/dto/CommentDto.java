package lt.techin.zoo.api.dto;


import lt.techin.zoo.model.Article;
import java.util.Objects;

public class CommentDto {

    private String author;

    private String text;


    private Article article;


    public CommentDto() {
    }

    public CommentDto( String author, String text, Article article) {

        this.author = author;
        this.text = text;
        this.article = article;
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

}
