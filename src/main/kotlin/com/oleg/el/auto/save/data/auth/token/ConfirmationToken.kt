package com.oleg.el.auto.save.data.auth.token

import com.oleg.el.auto.save.data.auth.AppUser
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class ConfirmationToken(
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
    )
    val id: Long? = -1,
    @Column(nullable = false)
    val token: String,
    @Column(nullable = false)
    val createdAt: LocalDateTime,
    @Column(nullable = false)
    val expiredAt: LocalDateTime,
    val confirmed: LocalDateTime,
    @ManyToOne
    @JoinColumn(
        nullable = false,
        name = "app_user_id"
    )
    val appUser: AppUser
)
