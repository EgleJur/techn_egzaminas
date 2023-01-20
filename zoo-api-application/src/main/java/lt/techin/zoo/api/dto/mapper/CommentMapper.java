package lt.techin.zoo.api.dto.mapper;

import lt.techin.zoo.api.dto.CommentDto;
import lt.techin.zoo.api.dto.CommentEntityDto;
import lt.techin.zoo.model.Comment;

public class CommentMapper {

    public static CommentDto toCommentDto(Comment comment) {
        var commentDto = new CommentDto();

        commentDto.setAuthor(comment.getAuthor());
        commentDto.setText(comment.getText());


        return commentDto;
    }

    public static Comment toComment(CommentDto commentDto) {
        var comment = new Comment();

        comment.setAuthor(commentDto.getAuthor());
        comment.setText(commentDto.getText());


        return comment;
    }

    public static CommentEntityDto toAnimalEntityDto(Comment comment) {
        var commentDto = new CommentEntityDto();
commentDto.setId(comment.getId());
        commentDto.setAuthor(comment.getAuthor());
        commentDto.setText(comment.getText());

        return commentDto;
    }

    public static Comment toAnimalFromEntityDto(CommentEntityDto commentDto) {
        var comment = new Comment();

        comment.setId(commentDto.getId());
        comment.setAuthor(commentDto.getAuthor());
        comment.setText(commentDto.getText());
        comment.setText(commentDto.getText());

        return comment;
    }


}
