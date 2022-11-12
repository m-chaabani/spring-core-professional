package com.mc.gestionformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code=HttpStatus.NOT_FOUND, reason = "utilisateur non existant" )
public class UserNotFoundException extends RuntimeException {


}
