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
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/rooms")
@Validated
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    @ResponseBody
    public List<ArticleDto> getRooms() {
        return articleService.getAll().stream()
                .map(ArticleMapper::toArticleDto)
                .collect(toList());

    }
//
//    @GetMapping("/{roomId}")
//    public ResponseEntity<ArticleDto> getRoom(@PathVariable Long articleId) {
//        var articleOptional = articleService.getById(articleId);
//
//        var responseEntity = articleOptional
//                .map(article -> ok(toArticleDto(article)))
//                .orElseGet(() -> ResponseEntity.notFound().build());
//
//        return responseEntity;
//    }
//
//    @DeleteMapping("/{roomId}")
//    public ResponseEntity<Void> deleteRoom(@PathVariable Long roomId) {
//        var roomDeleted = articleService.deleteById(roomId);
//
//        if (roomDeleted) {
//            return ResponseEntity.noContent().build();
//        }
//
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping
//    public ResponseEntity<RoomDto> createRoom(@Valid @RequestBody RoomDto roomDto) {
//        var createdRoom = articleService.create(toRoom(roomDto));
//
//        return ok(toRoomDto(createdRoom));
//    }
//
//    @PatchMapping("/{roomId}")
//    public ResponseEntity<RoomDto> updateRoom(@PathVariable Long roomId, @RequestBody RoomDto roomDto) {
//        var updatedRoom = articleService.update(roomId, toRoom(roomDto));
//
//        return ok(toRoomDto(updatedRoom));
//    }
//    @PutMapping("/{roomId}")
//    public ResponseEntity<RoomDto> replaceRoom(@PathVariable Long animalId, @RequestBody RoomDto roomDto) {
//        var updatedRoom = articleService.replace(animalId, toRoom(roomDto));
//
//        return ok(toRoomDto(updatedRoom));
//    }
//
//    @GetMapping("/custom")
//    public ResponseEntity<String> executeCustom(@RequestParam String input) {
//        var result = articleService.executeSpringDataNamedMethod(input);
//        return ok(result);
//    }
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
