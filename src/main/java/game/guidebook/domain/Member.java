package game.guidebook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String memberemail;

    private String memberpassword;

    private String membername;

    private String memberphone;

    private String membernickname;

    private String membergender;

    private String memberleave;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberemail() {
        return memberemail;
    }

    public void setMemberemail(String memberemail) {
        this.memberemail = memberemail;
    }

    public String getMemberpassword() {
        return memberpassword;
    }

    public void setMemberpassword(String memberpassword) {
        this.memberpassword = memberpassword;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getMemberphone() {
        return memberphone;
    }

    public void setMemberphone(String memberphone) {
        this.memberphone = memberphone;
    }

    public String getMembernickname() {
        return membernickname;
    }

    public void setMembernickname(String membernickname) {
        this.membernickname = membernickname;
    }

    public String getMembergender() {
        return membergender;
    }

    public void setMembergender(String membergender) {
        this.membergender = membergender;
    }

    public String getMemberleave() {
        return memberleave;
    }

    public void setMemberleave(String memberleave) {
        this.memberleave = memberleave;
    }
}
