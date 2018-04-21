package priv.rdo.sdawwa5.task07;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import priv.rdo.sdawwa5.task07.ErrorResponse.ValidationError;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.empty;
import static org.springframework.http.HttpStatus.I_AM_A_TEAPOT;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@RestControllerAdvice
public class Task07ControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(I_AM_A_TEAPOT)
    ErrorResponse handle(CustomException e, ServletWebRequest request) {
        return ErrorResponse.of(
                I_AM_A_TEAPOT,
                "my custom exception",
                request.getRequest().getRequestURI()
        );
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException e, ServletWebRequest request) {
        List<ValidationError> validationErrors = buildValidationErrors(e);

        return ErrorResponse.of(
                UNPROCESSABLE_ENTITY,
                "Validation failed",
                request.getRequest().getRequestURI(),
                validationErrors
        ).toResponseEntity();
    }

    private List<ValidationError> buildValidationErrors(MethodArgumentNotValidException e) {
        return Optional.of(e)
                .map(MethodArgumentNotValidException::getBindingResult)
                .map(Errors::getAllErrors)
                .map(Collection::stream)
                .orElse(empty())
                .map(this::asErrorDescription)
                .collect(toList());
    }

    private ValidationError asErrorDescription(ObjectError objectError) {
        FieldError fieldError = (FieldError) objectError;

        return new ValidationError(
                fieldError.getField(),
                fieldError.getDefaultMessage(),
                fieldError.getRejectedValue()
        );
    }
}
