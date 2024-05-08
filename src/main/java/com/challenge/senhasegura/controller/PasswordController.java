package com.challenge.senhasegura.controller;

import com.challenge.senhasegura.dto.PasswordDTO;
import com.challenge.senhasegura.service.PasswordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/validate-password")
public class PasswordController {

    private final PasswordService passwordService;

    private PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping
    public ResponseEntity<List<String>> validatePassword(@RequestBody PasswordDTO password) {
        List<String> requirementsList = this.passwordService.validatePassword(password.password());
        return !requirementsList.isEmpty() ? new ResponseEntity<>(requirementsList, HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
