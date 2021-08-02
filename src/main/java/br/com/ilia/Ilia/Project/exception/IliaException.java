package br.com.ilia.Ilia.Project.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
@Setter
public class IliaException extends ResponseStatusException {

    public IliaException(String reason, HttpStatus status){
        super(status, reason);
    }
}
