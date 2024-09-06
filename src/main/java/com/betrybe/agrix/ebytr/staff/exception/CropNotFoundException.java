package com.betrybe.agrix.ebytr.staff.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a crop is not found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CropNotFoundException extends Exception {
  public CropNotFoundException(String message) {
    super(message);
  }
}
