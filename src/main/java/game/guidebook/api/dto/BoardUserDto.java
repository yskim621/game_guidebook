package game.guidebook.api.dto;

import game.guidebook.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class BoardUserDto {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private String content;

    private Date writeDate;

    private Integer readCnt;

    private String attachment;

    private String userNickname;

    private Long userId;

    public BoardUserDto(Board board) {
        id = board.getId();
        title = board.getTitle();
        content = board.getContent();
        writeDate = board.getWriteDate();
        readCnt = board.getReadCnt();
        attachment = board.getAttachment();
        userNickname = board.getUserNickname();
    }
}
