package com.oleg.el.auto.save.data.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Order")
class CarNotFoundException(error:String): RuntimeException(error) {

}