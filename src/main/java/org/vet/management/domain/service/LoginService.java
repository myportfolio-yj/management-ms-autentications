package org.vet.management.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.vet.management.application.port.IPasswordEncryption;
import org.vet.management.application.port.out.ILoginRepository;
import org.vet.management.domain.model.Body;
import org.vet.management.domain.model.User;

@ApplicationScoped
public class LoginService {
  @Inject
  ILoginRepository loginRepository;
  @Inject
  IPasswordEncryption passwordEncryption;
  public String login(Body body) {
    User user = loginRepository.findByEmail(body.getEmail());
    return (passwordEncryption.checkPassword(body.getPassword(), user.getPassword())) ? "Logeado" : "Error";
  }
}
