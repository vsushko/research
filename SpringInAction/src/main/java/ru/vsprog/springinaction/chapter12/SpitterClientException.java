package ru.vsprog.springinaction.chapter12;

@SuppressWarnings("serial")
public class SpitterClientException extends RuntimeException {
  public SpitterClientException(String message, Throwable t) {
    super(message, t);
  }
}
