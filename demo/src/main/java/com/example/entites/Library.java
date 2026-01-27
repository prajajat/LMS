package com.example.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "librarys")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licenseNumber;

    private String name;
    private String location;



    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Book> books =new HashSet<>() ;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getLicenseNumber() {
//        return licenseNumber;
//    }
//
//    public void setLicenseNumber(String licenseNumber) {
//        this.licenseNumber = licenseNumber;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name= name;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location= location;
//    }






}


