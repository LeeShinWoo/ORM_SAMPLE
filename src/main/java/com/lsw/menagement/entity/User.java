package com.lsw.menagement.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "USER")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String userNm;

    @Column(name = "EMP_NO", nullable = false)
    private String empNo;
}
