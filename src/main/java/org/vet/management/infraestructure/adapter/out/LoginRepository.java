package org.vet.management.infraestructure.adapter.out;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.vet.management.application.port.out.ILoginRepository;
import org.vet.management.domain.model.User;
import org.vet.management.domain.model.UserEntity;

import java.util.Optional;

@ApplicationScoped
public class LoginRepository implements PanacheMongoRepository<UserEntity>, ILoginRepository {
  @Override
  public User findByEmail(String email) {
    Optional<UserEntity> result = find("email", email).firstResultOptional();
    if(result.isEmpty()) {
      return new User();
    }
    UserEntity userEntity = result.get();
    User user = new User();
    user.setId(userEntity.id.toString());
    user.setName(userEntity.name);
    user.setLastname(userEntity.lastname);
    user.setEmail(userEntity.email);
    user.setPassword(userEntity.password);
    return user;
  }
}
