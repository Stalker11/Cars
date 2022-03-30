package com.oleg.el.auto.save.data.services

import com.oleg.el.auto.save.data.auth.AppUser
import com.oleg.el.auto.save.data.auth.AppUserRole
import com.oleg.el.auto.save.data.auth.token.ConfirmationToken
import com.oleg.el.auto.save.data.auth.utils.EmailValidator
import com.oleg.el.auto.save.data.exceptions.models.RegisterNWModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime


@Service
class RegistrationServiceImpl: RegistrationService {

    @Autowired
    private lateinit var emailValidator: EmailValidator
    @Autowired
    private lateinit var appUserService: AppUserService
    @Autowired
    private lateinit var confirmationTokenService:ConfirmationTokenServiceImpl

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

    @Transactional
    override fun confirmToken(token: String): String {
        val confirmationToken: ConfirmationToken = confirmationTokenService
            .getToken(token)
            .orElseThrow { IllegalStateException("token not found") }
        //check(confirmationToken.confirmed) { "email already confirmed" }
        val expiredAt: LocalDateTime = confirmationToken.expiredAt
        check(!expiredAt.isBefore(LocalDateTime.now())) { "token expired" }
        confirmationTokenService.setConfirmedAt(token)
        appUserService.enableAppUser(
            confirmationToken.appUser.username
        )
        return "confirmed"
    }
}