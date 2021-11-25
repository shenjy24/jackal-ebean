package com.jonas.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    private Integer userId;
    private String userName;
    private Integer userAge;
    private Integer userStatus;
    private Long ctime;
    private Long utime;

    public User(String name, int age, int status) {
        this.userName = name;
        this.userAge = age;
        this.userStatus = status;
        this.ctime = System.currentTimeMillis();
        this.utime = System.currentTimeMillis();
    }
}
