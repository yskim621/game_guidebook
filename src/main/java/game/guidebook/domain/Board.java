package game.guidebook.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private Date writeDate;

    private Integer readCnt = 0;

    private String attachment;

    private String userNickname;

//    private Long userId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
}
