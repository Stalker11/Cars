package com.oleg.el.auto.save.data.services

import com.oleg.el.auto.save.data.auth.AppUser
import com.oleg.el.auto.save.data.auth.token.ConfirmationToken
import com.oleg.el.auto.save.data.repository.UserRepository
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class AppUserService() : UserDetailsService {
    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder
    @Autowired
    private lateinit var confirmationTokenServiceImpl: ConfirmationTokenServiceImpl

    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByEmail(username).orElseThrow {
            UsernameNotFoundException("User not found")
        }
    }

    fun signUpUser(appUser: AppUser): String {
       val isExist = userRepository.findByEmail(appUser.username).isPresent
        if (isExist){
            throw IllegalStateException("user already exist")
        }
       val encode = bCryptPasswordEncoder.encode(appUser.password)

       val data = userRepository.save(appUser.copy(password = encode))

        val token = UUID.randomUUID().toString()
        val confirmationToken = ConfirmationToken(
            token = token,
            createdAt = LocalDateTime.now(),
            expiredAt = LocalDateTime.now().plusMinutes(180),
            confirmed = LocalDateTime.now(),
            appUser = data
        )
        println(data.username)
        confirmationTokenServiceImpl.saveConfirmationToken(confirmationToken)
        //TODO send the email
        return token
    }
}