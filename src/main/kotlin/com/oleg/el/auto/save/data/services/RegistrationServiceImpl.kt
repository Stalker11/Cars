package com.oleg.el.auto.save.data.services

import com.oleg.el.auto.save.data.exceptions.models.RegisterNWModel
import org.springframework.stereotype.Service

@Service
class RegistrationServiceImpl: RegistrationService {
    override fun register(request: RegisterNWModel) = "succeed"
}