package com.skypro.CourseWork2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class TooManyQuestionsException extends RuntimeException {
    public TooManyQuestionsException() {
    }

    public TooManyQuestionsException(String message) {
        super(message);
    }

    public TooManyQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooManyQuestionsException(Throwable cause) {
        super(cause);
    }

    public TooManyQuestionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
