package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Exception thrown when a resource is not found.
 */
public class NotFoundException extends Exception {
  public NotFoundException(String message) {
    super(message);
  }
}
