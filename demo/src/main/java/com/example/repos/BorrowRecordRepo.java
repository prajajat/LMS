package com.example.repos;

import com.example.entites.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepo extends JpaRepository<BorrowRecord,Long> {
}
