package rjhuizing.slimmer.coding.test.config

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Stub, used to send custom error messages when encountering exceptions in controllers
 */
@ControllerAdvice
class CustomExceptionHandler {

    @ResponseBody
    @ExceptionHandler()
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun rentalExceptionHandler(ex: Exception): String? {
        return ex.message
    }
}