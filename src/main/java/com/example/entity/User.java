package com.example.entity;

import com.example.entity.enums.ERole;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class User extends BaseEntity{

    private String name;
    private String username;
    private String lastname;
    private String email;
    private String bio;
    private String password;

    private Set<ERole> role = new HashSet<>();
    private List<Post> posts = new ArrayList<>();

}
