package com.fittracker.fittracker.exceptions;

public class ExistingEmailException extends RuntimeException {
  public ExistingEmailException(String message) {
    super(message);
  }
}