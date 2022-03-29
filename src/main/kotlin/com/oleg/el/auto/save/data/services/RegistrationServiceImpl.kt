package com.oleg.el.auto.save.data.services

import com.oleg.el.auto.save.data.auth.AppUser
import com.oleg.el.auto.save.data.auth.AppUserRole
import com.oleg.el.auto.save.data.auth.utils.EmailValidator
import com.oleg.el.auto.save.data.exceptions.models.RegisterNWModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RegistrationServiceImpl: RegistrationService {

    @Autowired
    private lateinit var emailValidator: EmailValidator
    @Autowired
    private lateinit var appUserService: AppUserService
    override fun register(request: RegisterNWModel): String = if (emailValidator.test(request.email)){
        appUserService.signUpUser(AppUser(
            name = request.firstName,
            userName = request.secondName,
            email = request.email,
            password = request.password,
            role = AppUserRole.USER
        ))
    }
        else {
            throw IllegalAccessException("email not valid")
    }
}