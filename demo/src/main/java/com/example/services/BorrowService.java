package com.example.services;

import com.example.StatusType;
import com.example.componets.DateUtils;
import com.example.dtos.BookDTO;
import com.example.dtos.BorrowDTO;
import com.example.entites.Book;
import com.example.entites.BorrowRecord;
import com.example.entites.Library;
import com.example.entites.Member;
import com.example.repos.BookRepo;
import com.example.repos.BorrowRecordRepo;
import com.example.repos.LibraryRepo;
import com.example.repos.MemberRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BorrowService {
    private final BorrowRecordRepo borrowRecordRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public BorrowService(BorrowRecordRepo borrowRecordRepo) {
        this.borrowRecordRepo = borrowRecordRepo;

    }

    @Autowired
    private LibraryRepo libraryRepo;
    @Autowired
    private MemberRepo memberRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private DateUtils dateUtils;

    @Transactional
    public BorrowRecord createBorrow(BorrowDTO dto) {
        Library library = libraryRepo.findById(dto.getLibraryId()).orElseThrow(() -> new RuntimeException("library not found"));
        Member member = memberRepo.findById(dto.getMemberId()).orElseThrow(() -> new RuntimeException("member not found"));
        Book book = bookRepo.findById(dto.getBookId()).orElseThrow(() -> new RuntimeException("book not found"));
        if (book.isAvailable() == false) {
            throw new RuntimeException("book is not Available ");
        }
            BorrowRecord borrowRecord = new BorrowRecord();

            borrowRecord.setReturnDate(dto.getReturnDate());
            borrowRecord.setBorrowingStatus(StatusType.BorrowingStatus.BORROWED);
            borrowRecord.setBook(book);
            borrowRecord.setMember(member);
            borrowRecord.setBorrowDate(dateUtils.today());


            return borrowRecordRepo.save(borrowRecord);
        }

}
