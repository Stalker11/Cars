package com.oleg.el.auto.save.data.exceptions.models

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus
import java.time.ZonedDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CarNotFoundExceptionModel(
    val message: String? = null, val throwable: Throwable? = null,
    val httpStatus: HttpStatus? = null, val timeStamp: ZonedDateTime? = null
)
