package com.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private LocalDateTime membershipDate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BorrowRecord> BorrowRecords;

}
