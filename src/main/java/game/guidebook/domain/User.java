package game.guidebook.domain;

import game.common.persist.entity.AbstractEntity;
import game.guidebook.domain.enumerate.UserSource;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String password;

    private String name;

    private String mobile;

    private String nickname;

    private String gender;

    private String leaveUserId;

    private String lastLoginIp;

    private Date lastLoginTime;

    private Integer loginCount;

    private Integer loginErrCount;

    private String createName;

    private String updateName;

    private Date createTime;

    private Date updateTime;

    private UserSource resource;

//    @OneToMany(mappedBy = "user")
//    private List<Board> boards = new ArrayList<>();

}
