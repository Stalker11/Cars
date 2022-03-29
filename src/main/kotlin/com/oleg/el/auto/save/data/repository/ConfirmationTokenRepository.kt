package com.oleg.el.auto.save.data.repository

import com.oleg.el.auto.save.data.auth.token.ConfirmationToken
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ConfirmationTokenRepository: JpaRepository<ConfirmationToken, Long> {
    fun findByToken(token:String): Optional<ConfirmationToken>
}