package lt.techin.zoo.api.dto;


import lt.techin.zoo.model.Article;

import java.util.Objects;

public class CommentEntityDto extends CommentDto {

    private Long id;

    public CommentEntityDto() {
    }

    public CommentEntityDto(String author, String text, Article article) {
        super(author, text, article);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
