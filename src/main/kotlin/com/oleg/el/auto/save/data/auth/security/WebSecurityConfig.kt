package com.oleg.el.auto.save.data.auth.security

import com.oleg.el.auto.save.data.auth.token.CustomAuthenticationFilter
import com.oleg.el.auto.save.data.services.AppUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfig() : WebSecurityConfigurerAdapter() {
    @Autowired
    private lateinit var service: AppUserService
    @Autowired
    private lateinit var password: BCryptPasswordEncoder
    override fun configure(http: HttpSecurity?) {
        http?.csrf()
            ?.disable()
            ?.authorizeRequests()
            ?.antMatchers("/api/v*/auth/**")
            ?.permitAll()
            ?.anyRequest()
            ?.authenticated()
            ?.and()
            ?.formLogin()
        http?.addFilter(CustomAuthenticationFilter(authenticationManagerBean()))
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.authenticationProvider(provider())
    }

    @Bean
    fun provider():DaoAuthenticationProvider{
        val provider = DaoAuthenticationProvider()
        provider.setPasswordEncoder(password)
        provider.setUserDetailsService(service)
        return provider
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }
}