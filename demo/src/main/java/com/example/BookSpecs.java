package com.example;

import com.example.dtos.FilterDTO;
import com.example.entites.Book;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

public class BookSpecs {

        public static Specification<Book> withParams(FilterDTO params) {
            return (root, query, cb) -> {

                List<Predicate> predicates = new ArrayList<>();
                if (params.getAuthor() != null) {
                    predicates.add((Predicate) cb.equal(root.get("author"), params.getAuthor()));
                }
                if (params.getTitle() != null) {
                    predicates.add((Predicate) cb.like(root.get("title"), "%" + params.getTitle() + "%"));
                }
                if (params.getIsAvailable() != null) {
                    predicates.add((Predicate) cb.like(root.get("isAvailable"), "%" + params.getIsAvailable() + "%"));
                }

                //WHERE p1 AND p2 AND p3
                return cb.and(predicates.toArray(new Predicate[0]));

            };
        }
    }

