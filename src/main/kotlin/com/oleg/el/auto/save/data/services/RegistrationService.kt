package com.oleg.el.auto.save.data.services

import com.oleg.el.auto.save.data.exceptions.models.RegisterNWModel

interface RegistrationService {
    fun register(request: RegisterNWModel): String
}