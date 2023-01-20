package lt.techin.zoo.api.dto.mapper;

import lt.techin.zoo.api.dto.ArticleDto;
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




}
