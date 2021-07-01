package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(updatable = false)
    protected LocalDateTime createdDate;

    public BaseEntity(Long id) {
        this.id = id;
    }


    @PrePersist
    protected void onCreate(){
        this.createdDate = LocalDateTime.now();
    }
}
