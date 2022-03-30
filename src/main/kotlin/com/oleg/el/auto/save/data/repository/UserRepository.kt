package com.oleg.el.auto.save.data.repository

import com.oleg.el.auto.save.data.auth.AppUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*


@Repository
@Transactional(readOnly = true)
interface UserRepository: JpaRepository<AppUser, Long> {
   fun findByEmail(email:String): Optional<AppUser>

   @Transactional
   @Modifying
   @Query(
      "UPDATE AppUser a " +
              "SET a.enabled = TRUE WHERE a.email = ?1"
   )
   fun enableAppUser(email: String?): Int
}