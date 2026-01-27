package com.example.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private LocalDateTime membershipDate;


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<BorrowRecord> borrowRecords ;

    @OneToOne(mappedBy = "member",cascade = CascadeType.ALL)
    private MemberProfile memberProfile;
}
