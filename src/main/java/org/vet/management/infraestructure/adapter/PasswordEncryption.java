package org.vet.management.infraestructure.adapter;
import jakarta.enterprise.context.ApplicationScoped;
import org.mindrot.jbcrypt.BCrypt;
import org.vet.management.application.port.IPasswordEncryption;

@ApplicationScoped
public class PasswordEncryption implements IPasswordEncryption {

  @Override
  public boolean checkPassword(String password, String hashedPassword) {
    return BCrypt.checkpw(password, hashedPassword);
  }
}
