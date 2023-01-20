package lt.techin.zoo.api;

import lt.techin.zoo.api.dto.CommentDto;
import lt.techin.zoo.api.dto.mapper.CommentMapper;
import lt.techin.zoo.model.Comment;
import lt.techin.zoo.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;


@Controller
@RequestMapping("/api/v1/animals")
public class CommentController {

    public static Logger logger = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<CommentDto> getAnimals() {
        return commentService.getAll().stream()
                .map(CommentMapper::toCommentDto)
                .collect(toList());
    }

//    @GetMapping(value = "/{animalId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//
//    public ResponseEntity<Comment> getAnimal(@PathVariable Long animalId) {
//        var animalOptional = commentService.getById(animalId);
//
//        var responseEntity = animalOptional
//                .map(animal -> ok(animal))
//                .orElseGet(() -> ResponseEntity.notFound().build());
//
//        return responseEntity;
//    }
//
//    @DeleteMapping("/{animalId}")
//    public ResponseEntity<Void> deleteAnimal(@PathVariable Long animalId) {
//        logger.info("Attempt to delete Animal by id: {}", animalId);
//
//        boolean deleted = commentService.deleteById(animalId);
//        if (deleted) {
//            return ResponseEntity.noContent().build();
//
//            //galima konstruoti ir taip, visi variantai teisingi
//            //return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//            return ResponseEntity.notFound().build();
//
//    }
//
//    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<AnimalDto> createAnimal(@RequestBody AnimalDto animalDto) {
//        var createdAnimal = commentService.create(toAnimal(animalDto));
//
//        return ok(toAnimalDto(createdAnimal));
//    }
//
//    @PutMapping("/{animalId}")
//    public ResponseEntity<AnimalDto> replaceAnimal(@PathVariable Long animalId, @RequestBody AnimalDto animalDto) {
//        var updatedAnimal = commentService.replace(animalId, toAnimal(animalDto));
//
//        return ok(toAnimalDto(updatedAnimal));
//    }
//
//    @PatchMapping("/{animalId}")
//    public ResponseEntity<AnimalDto> updateAnimal(@PathVariable Long animalId, @RequestBody AnimalDto animalDto) {
//        var updatedAnimal = commentService.update(animalId, toAnimal(animalDto));
//
//        return ok(toAnimalDto(updatedAnimal));
//    }
//
//    @PostMapping("/{animalId}/addroom")
//    @ResponseBody
//    public Comment addRoomToAnimal(@PathVariable Long animalId, @RequestParam Long roomId) {
//        return commentService.addRoomToAnimal(animalId, roomId);
//    }
//
//    @PostMapping("/registry/clear")
//    public ResponseEntity<Integer> deleteNonRegAnimal() {
//        var removedCount = commentService.deleteNonRegistered();
//
//        return ok(removedCount);
//    }
//
//    @GetMapping("/marked")
//    @ResponseBody
//    public List<AnimalEntityDto> findMarkedAnimals() {
//        return commentService.findMarkedAnimals().stream()
//                .map(CommentMapper::toAnimalEntityDto)
//                .collect(toList());
//    }
}
