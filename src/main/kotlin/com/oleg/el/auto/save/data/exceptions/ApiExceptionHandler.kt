package com.oleg.el.auto.save.data.exceptions

import com.oleg.el.auto.save.data.exceptions.models.CarNotFoundExceptionModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.ZonedDateTime

@ControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(CarNotFoundException::class)
    fun handleNotFoundExceptionById(exception: CarNotFoundException): ResponseEntity<Any> {
    return ResponseEntity(CarNotFoundExceptionModel(exception.message,
    timeStamp = ZonedDateTime.now()), HttpStatus.NOT_FOUND)
    }
}