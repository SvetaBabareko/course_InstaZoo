package com.example.demo.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin
@ResponseStatus
@RequestMapping("/api/auth")
@PreAuthorize("permitAll()")
public class AuthController {


}
