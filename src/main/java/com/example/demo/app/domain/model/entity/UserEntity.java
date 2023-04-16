package com.example.demo.app.domain.model.entity;

import com.example.demo.app.domain.model.util.HashUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userid;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String residentid;

    @Column(nullable = false)
    private String phonenum;

    @Column(nullable = false)
    private String address;

    @Builder
    public UserEntity(String userid, String password, String residentid, String phonenum, String address){
        this.userid = userid;
        this.password = password;
        this.residentid = residentid;
        this.phonenum = phonenum;
        this.address = address;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(HashUtil.sha256(password));
    }

    public boolean checkUserid(String userid) {
        return this.userid.equals(HashUtil.sha256(userid));
    }

    public boolean checkResidentid(String residentid) {
        return this.residentid.equals(HashUtil.sha256(residentid));
    }

    public boolean checkPhonenum(String phonenum) {
        return this.phonenum.equals(HashUtil.sha256(phonenum));
    }

    public void setPassword(String password) { this.password = HashUtil.sha256(password); }

    public void setUserid(String userid) {this.userid = HashUtil.sha256(userid); }

    public void setResidentid(String residentid) { this.residentid = HashUtil.sha256(residentid); }

    public void setPhonenum(String phonenum) { this.phonenum = HashUtil.sha256(phonenum); }
}
