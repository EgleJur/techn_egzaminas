package lt.techin.zoo.api.dto;


public class ArticleEntityDto extends ArticleDto {

    private Long id;


    public ArticleEntityDto() {
    }

    public ArticleEntityDto(Long id, String name, String description) {
        super(name, description);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
