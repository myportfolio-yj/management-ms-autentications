package org.vet.management.infraestructure.adapter.in;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.vet.management.application.port.in.ILogin;
import org.vet.management.domain.model.Body;
import org.vet.management.domain.service.LoginService;

public class LoginResource implements ILogin {
  @Inject
  LoginService loginService;
  @Override
  public Response login(Body body) {
    return Response.ok(loginService.login(body)).build();
  }
}
