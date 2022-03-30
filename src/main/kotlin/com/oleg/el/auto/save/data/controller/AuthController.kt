package com.oleg.el.auto.save.data.controller

import com.oleg.el.auto.save.data.exceptions.models.RegisterNWModel
import com.oleg.el.auto.save.data.services.RegistrationService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/auth")
class AuthController(private val registerService: RegistrationService)
{
    @PostMapping("/create")
    fun register(@RequestBody body: RegisterNWModel) =
        registerService.register(body)

    @GetMapping(path = ["confirm"])
    fun confirm(@RequestParam("token") token: String): String {
        return registerService.confirmToken(token)
    }

}