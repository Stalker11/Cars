package com.oleg.el.auto.save.data.auth.utils

import org.springframework.stereotype.Service
import java.util.function.Predicate

@Service
class EmailValidator: Predicate<String> {
    private val pattern = Regex("^[a-zA-ZåäöÅÄÖß0-9._-]+@[a-zåäöß0-9]+\\.[a-zåäöß.]{2,5}\$")
    override fun test(t: String): Boolean {
        return pattern.matches(t)
    }
}