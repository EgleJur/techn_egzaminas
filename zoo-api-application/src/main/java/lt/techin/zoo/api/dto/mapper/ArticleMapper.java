package lt.techin.zoo.api.dto.mapper;

import lt.techin.zoo.api.dto.ArticleDto;
import lt.techin.zoo.model.Article;

public class ArticleMapper {

    public static ArticleDto toArticleDto(Article article) {
        var articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setName(article.getName());
        articleDto.setCreatedDate(article.getCreatedDate());
        articleDto.setDescription(article.getDescription());
        articleDto.setCreatedDate(article.getCreatedDate());

        return articleDto;
    }

    public static Article toArticle(ArticleDto articleDto) {
        var article = new Article();
        article.setId(articleDto.getId());
        article.setName(articleDto.getName());
        article.setCreatedDate(articleDto.getCreatedDate());
        article.setDescription(articleDto.getDescription());
        article.setCreatedDate(articleDto.getCreatedDate());

        return article;
    }



}
