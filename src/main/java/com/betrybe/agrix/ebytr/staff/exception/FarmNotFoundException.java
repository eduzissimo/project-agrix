package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Represents an exception thrown when a farm is not found.
 */
public class FarmNotFoundException extends NotFoundException {

  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
