package lt.techin.zoo.api.dto.mapper;

import lt.techin.zoo.api.dto.ArticleDto;
import lt.techin.zoo.api.dto.ArticleEntityDto;
import lt.techin.zoo.model.Article;

public class ArticleMapper {

    public static ArticleDto toArticleDto(Article article) {
        var articleDto = new ArticleDto();

        articleDto.setName(article.getName());
        articleDto.setDescription(article.getDescription());

        return articleDto;
    }

    public static Article toArticle(ArticleDto articleDto) {
        var article = new Article();
        article.setName(articleDto.getName());
        article.setDescription(articleDto.getDescription());

        return article;
    }

    public static ArticleEntityDto toArticleEntityDto(Article article) {
        var articleDto = new ArticleEntityDto();
        articleDto.setId(articleDto.getId());
        articleDto.setName(article.getName());
        articleDto.setDescription(article.getDescription());

        return articleDto;
    }

    public static Article toArticle(ArticleEntityDto articleEntityDto) {
        var article = new Article();
        article.setId(articleEntityDto.getId());
        article.setName(articleEntityDto.getName());
        article.setDescription(articleEntityDto.getDescription());

        return article;
    }


}
