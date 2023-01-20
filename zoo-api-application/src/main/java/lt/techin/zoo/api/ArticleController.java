package lt.techin.zoo.api;

import lt.techin.zoo.api.dto.ArticleDto;
import lt.techin.zoo.api.dto.mapper.ArticleMapper;
import lt.techin.zoo.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.zoo.api.dto.mapper.ArticleMapper.*;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/articles")
@Validated
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    @ResponseBody
    public List<ArticleDto> getArticles() {
        return articleService.getAll().stream()
                .map(ArticleMapper::toArticleDto)
                .collect(toList());

    }


    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable Long articleId) {
        var articleOptional = articleService.getById(articleId);

        var responseEntity = articleOptional
                .map(article -> ok(toArticleDto(article)))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long articleId) {
        var articleDeleted = articleService.deleteById(articleId);

        if (articleDeleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ArticleDto> createArticle(@Valid @RequestBody ArticleDto articleDto) {
        var createdRoom = articleService.create(toArticle(articleDto));

        return ok(toArticleDto(createdRoom));
    }

//
//    @GetMapping("/type/top")
//    public ResponseEntity<List<RoomDto>> findLatestByType(@RequestParam RoomType type) {
//        var result = articleService.findByType(type).stream()
//                .map(ArticleMapper::toRoomDto)
//                .collect(toList());
//
//        return ok(result);
//    }
//    @GetMapping("/search")
//    @ResponseBody
//    public List<RoomEntityDto> findRoomsPaged(@RequestParam(required = false) String name, @RequestParam(required = false) RoomType type,
//                                              @RequestParam int page, @RequestParam int pageSize) {
//        return articleService.findByExample(name, type, page, pageSize).stream()
//                .map(ArticleMapper::toRoomEntityDto)
//                .collect(toList());
//    }
}
