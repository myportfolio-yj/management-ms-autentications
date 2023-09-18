package org.vet.management.application.port.out;

import org.vet.management.domain.model.User;

public interface ILoginRepository {
  User findByEmail(String email);
}
