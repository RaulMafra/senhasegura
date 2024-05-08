package com.challenge.senhasegura.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {

    List<String> requirementsList;

    public List<String> validatePassword(String password) {
        requirementsList = new ArrayList<>();
        this.validateCharsQuantity(password);
        this.validateUpperCase(password);
        this.validateLowerCase(password);
        this.validateDigit(password);
        this.validateSpecialChar(password);
        return requirementsList;
    }

    private void validateCharsQuantity(String password) {
        if (password.length() < 8) {
            requirementsList.add("Password must has at least 8 characters");
        }
    }

    private void validateUpperCase(String password) {
        if (password.chars().noneMatch(Character::isUpperCase)) {
            requirementsList.add("Password must has at least one upper case letter");
        }
    }

    private void validateLowerCase(String password) {
        if (password.chars().noneMatch(Character::isLowerCase)) {
            requirementsList.add("Password must has at least one lower case letter");

        }
    }

    private void validateDigit(String password) {
        if (password.chars().noneMatch(Character::isDigit)) {
            requirementsList.add("Password must has at least one digit");
        }
    }

    private void validateSpecialChar(String password) {
        if (!Pattern.compile("(\\W)").matcher(password).find()) {
            requirementsList.add("Password must has at least one special character");
        }
    }
}

