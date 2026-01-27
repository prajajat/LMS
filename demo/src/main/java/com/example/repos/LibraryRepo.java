package com.example.repos;


import com.example.entites.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepo extends JpaRepository<Library,Long> {
}
