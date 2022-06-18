package game.guidebook.api.dto;

import game.guidebook.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
public class BoardDto {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private String content;

    private Date writeDate;

    private Integer readCnt;

    private String attachment;

    private String userNickname;

//    private Long userId;

    public BoardDto(Board board) {
        id = board.getId();
        title = board.getTitle();
        content = board.getContent();
        writeDate = board.getWriteDate();
        readCnt = board.getReadCnt();
        attachment = board.getAttachment();
        userNickname = board.getUserNickname();
    }
}
