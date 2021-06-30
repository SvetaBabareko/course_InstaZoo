package com.example.entity;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class BaseEntity {
    protected Long id;
    protected LocalDateTime createdDate;

    @PrePersist
    protected void onCreate(){
        this.createdDate = LocalDateTime.now();
    }
}
