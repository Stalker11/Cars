package com.oleg.el.auto.save.data.repository

import com.oleg.el.auto.save.data.auth.AppUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Repository
@Transactional(readOnly = true)
interface UserRepository: JpaRepository<AppUser, Long> {
   fun findByEmail(email:String): Optional<AppUser>
}