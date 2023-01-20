package lt.techin.zoo.api.dto.mapper;

import lt.techin.zoo.api.dto.CommentDto;
import lt.techin.zoo.model.Comment;

public class CommentMapper {

    public static CommentDto toCommentDto(Comment comment) {
        var commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setAuthor(comment.getAuthor());
        commentDto.setText(comment.getText());



        return commentDto;
    }

    public static Comment toComment(CommentDto commentDto) {
        var comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setAuthor(commentDto.getAuthor());
        comment.setText(commentDto.getText());



        return comment;
    }




}
