package br.com.ilia.Ilia.Project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class IliaExceptionHandler  {

    @ExceptionHandler(IliaException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleException(IliaException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        List<Object> list =  new ArrayList<>();

        body.put("mensagem", ex.getReason());
        body.put("alocacoes", list);


        return new ResponseEntity<>(body, ex.getStatus());
    }
}