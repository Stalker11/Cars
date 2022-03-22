package com.oleg.el.auto.save.data.services

import com.oleg.el.auto.save.data.repository.UserRepository
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AppUserService() : UserDetailsService {
    @Autowired
    private lateinit var userRepository: UserRepository
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByEmail(username).orElseThrow()
    }
}