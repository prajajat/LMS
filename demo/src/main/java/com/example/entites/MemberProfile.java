package com.example.entites;

import com.example.StatusType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "member_profile")
public class MemberProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    @Enumerated(EnumType.STRING)
    private StatusType.GenderType gender;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name="member_id")
    private Member member;

}
