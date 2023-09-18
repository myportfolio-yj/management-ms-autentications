package org.vet.management.application.port;

public interface IPasswordEncryption {
  public boolean checkPassword(String password, String hashedPassword);
}
