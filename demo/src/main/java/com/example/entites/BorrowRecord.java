package com.example.entites;

import com.example.StatusType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity

@Table(name = "borrow_records")
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime borrowDate;

    private LocalDateTime returnDate;

    @Enumerated(EnumType.STRING)
    private StatusType.BorrowingStatus borrowingStatus;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="book_id")
    private Book book;

}
