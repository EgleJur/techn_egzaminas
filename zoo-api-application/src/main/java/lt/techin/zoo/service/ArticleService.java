package lt.techin.zoo.service;

import lt.techin.zoo.dao.ArticleRepository;
import lt.techin.zoo.exception.ZooValidationException;
import lt.techin.zoo.model.Article;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;

    }

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> getById(Long id) {
        return articleRepository.findById(id);
    }


    public Article create(Article article) {

        return articleRepository.save(article);
    }


    public boolean deleteById(Long id) {
        try {
            articleRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

//
//    private static final ExampleMatcher SEARCH_CONDITIONS_MATCH_ANY = ExampleMatcher
//            .matchingAny()
////            .withMatcher("date??", ExampleMatcher.GenericPropertyMatchers.exact())
//            .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
//            .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.exact())
//            .withIgnorePaths("id", "description",
//                    "createdDate", "modifiedDate", "createdBy", "modifiedBy");
//
//    private Pageable pageable(int page, int pageSize, String sortField, Sort.Direction sortDirection) {
//        return PageRequest.of(page, pageSize, sortDirection, sortField);
//    }


}
