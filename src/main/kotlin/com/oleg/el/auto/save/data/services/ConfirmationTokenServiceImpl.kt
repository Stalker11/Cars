package com.oleg.el.auto.save.data.services

import com.oleg.el.auto.save.data.auth.token.ConfirmationToken
import com.oleg.el.auto.save.data.repository.ConfirmationTokenRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*


@Service
class ConfirmationTokenServiceImpl {

    @Autowired
    private lateinit var confirmationTokenRepository:ConfirmationTokenRepository

    fun saveConfirmationToken(token:ConfirmationToken){
        confirmationTokenRepository.save(token)
    }

    fun getToken(token: String?): Optional<ConfirmationToken> {
        return confirmationTokenRepository.findByToken(token!!)
    }

    fun setConfirmedAt(token: String): Int {
        return confirmationTokenRepository.updateConfirmedAt(
            token, LocalDateTime.now()
        )
    }
}