package lt.techin.zoo.api;

import lt.techin.zoo.api.dto.ArticleDto;
import lt.techin.zoo.api.dto.CommentDto;
import lt.techin.zoo.api.dto.mapper.CommentMapper;
import lt.techin.zoo.model.Comment;
import lt.techin.zoo.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.zoo.api.dto.mapper.ArticleMapper.toArticleDto;
import static lt.techin.zoo.api.dto.mapper.CommentMapper.toComment;
import static lt.techin.zoo.api.dto.mapper.CommentMapper.toCommentDto;
import static org.springframework.http.ResponseEntity.ok;


@Controller
@RequestMapping("/api/v1/comments")
public class CommentController {

    public static Logger logger = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<CommentDto> getComments() {
        return commentService.getAll().stream()
                .map(CommentMapper::toCommentDto)
                .collect(toList());
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDto> getComment(@PathVariable Long commentId) {
        var commentOptional = commentService.getById(commentId);

        var responseEntity = commentOptional
                .map(comment -> ok(toCommentDto(comment)))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;


    }
//
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        logger.info("Attempt to delete Comment by id: {}", commentId);

        boolean deleted = commentService.deleteById(commentId);
        if (deleted) {
            return ResponseEntity.noContent().build();

        }
            return ResponseEntity.notFound().build();

    }

@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto) {
    var createdComment = commentService.create(toComment(commentDto));

    return ok(toCommentDto(createdComment));
}


}
