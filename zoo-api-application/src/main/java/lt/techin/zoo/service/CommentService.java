package lt.techin.zoo.service;

import lt.techin.zoo.dao.CommentRepository;
import lt.techin.zoo.dao.ArticleRepository;
import lt.techin.zoo.exception.ZooValidationException;
import lt.techin.zoo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    @Autowired //jeigu nenurodytume Spring'as (nuo 4.3 versijos) pridetu vieninteliam managed Bean klases konstruktoriuj @Autowired automatiskai
    public CommentService(CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

//    public Optional<Comment> getById(Long id) {
//        return commentRepository.findById(id);
//    }
//
//
//    public Comment create(Comment comment) {
//        return commentRepository.save(comment);
//    }
//
//    public Comment update(Long id, Comment comment) {
//        var existingAnimal = commentRepository.findById(id)
//                .orElseThrow(() -> new ZooValidationException("Animal does not exist",
//                        "id", "Animal not found", id.toString()));
//
//        existingAnimal.setAuthor(comment.getAuthor());
//                existingAnimal.setText(comment.getText());
//
//        return commentRepository.save(existingAnimal);
//    }
//
//    public Comment replace(Long id, Comment comment) {
//        comment.setId(id);
//
//        return commentRepository.save(comment);
//    }
//
//    public boolean deleteById(Long id) {
//        try {
//            commentRepository.deleteById(id);
//            return true;
//        } catch (EmptyResultDataAccessException exception) {
//            return false;
//        }
//    }
//
//    public List<Comment> findMarkedAnimals() {
//        return commentRepository.findAllMarkedAnimals();
//    }
//
//    @Transactional
//    public int deleteNonRegistered() {
//        return commentRepository.deleteNonRegisteredAnimals();
//    }
//
//    public Comment addRoomToAnimal(Long animalId, Long roomId) {
//        // - find animal
//        var existingAnimal = commentRepository.findById(animalId)
//                .orElseThrow(() -> new ZooValidationException("Animal does not exist",
//                        "id", "Animal not found", animalId.toString()));
//
//        // - find room
//        var existingRoom = articleRepository.findById(roomId)
//                .orElseThrow(() -> new ZooValidationException("Room does not exist",
//                        "id", "Room not found", roomId.toString()));
//
//        // - if OK - set
//        existingAnimal.setRoom(existingRoom);
//
//        return commentRepository.save(existingAnimal);
//    }

}
