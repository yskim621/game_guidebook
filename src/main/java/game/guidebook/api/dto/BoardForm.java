package game.guidebook.api.dto;

import game.guidebook.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class BoardForm {

    private static final long serialVersionUID = 1L;

    private String title;

    private String content;

    private String attachment;

    private String userNickname;

}
