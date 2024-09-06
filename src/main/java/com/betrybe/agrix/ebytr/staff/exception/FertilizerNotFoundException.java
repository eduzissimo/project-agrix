package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Exception thrown when a fertilizer is not found.
 */
public class FertilizerNotFoundException extends RuntimeException {

  public FertilizerNotFoundException(String message) {
    super(message);
  }

}
