package lt.techin.zoo.api.dto;

import java.util.Objects;


public class ArticleDto {


    private String name;

    private String description;


    public ArticleDto() {
    }

    public ArticleDto( String name, String description) {
             this.name = name;
        this.description = description;
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

}
