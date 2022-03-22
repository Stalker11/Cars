package com.oleg.el.auto.save.data.controller

import com.oleg.el.auto.save.data.exceptions.models.RegisterNWModel
import com.oleg.el.auto.save.data.services.RegistrationService
import com.oleg.el.auto.save.data.services.RegistrationServiceImpl
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(private val registerService: RegistrationService)
{
    @PostMapping("/create")
    fun register(@RequestBody body: RegisterNWModel) =
        registerService.register(body)

}